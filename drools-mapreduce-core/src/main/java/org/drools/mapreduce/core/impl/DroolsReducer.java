package org.drools.mapreduce.core.impl;

import java.util.Iterator;

import org.drools.mapreduce.core.api.Collector;
import org.drools.mapreduce.core.api.Reducer;
import org.drools.mapreduce.core.model.entry.Entry;
import org.drools.mapreduce.core.model.entry.RunningReduce;
import org.drools.mapreduce.core.util.DroolsHelper;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class DroolsReducer implements Reducer<String, String, String, String> {
	private final KieContainer kieContainer;

	public DroolsReducer() {
		this.kieContainer = DroolsHelper.createClasspathKieContainer();
	}

	public void reduce(String key, Iterator<String> values,
			Collector<String, String> collector) {
		if (!values.hasNext()) {
			// No values!
			return;
		}

		String initialValue = values.next();
		RunningReduce runningReduce = new RunningReduce(key.toString(),
				initialValue.toString());

		while (values.hasNext()) {
			String nextValue = values.next();
			KieSession kieSession = kieContainer.newKieSession();
			kieSession.insert(runningReduce);
			Entry entry = new Entry(key.toString(), nextValue.toString());
			kieSession.insert(entry);
			DroolsHelper.fireAgendaGroup(kieSession, "reducer-rules");
			kieSession.dispose();
		}
		
		collector.collect(runningReduce.key, runningReduce.value);
	}
}
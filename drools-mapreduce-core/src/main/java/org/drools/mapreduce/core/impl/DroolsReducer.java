package org.drools.mapreduce.core.impl;

import java.util.Iterator;

import org.drools.mapreduce.core.api.Collector;
import org.drools.mapreduce.core.api.Reducer;
import org.drools.mapreduce.core.model.entry.Entry;
import org.drools.mapreduce.core.model.entry.RunningReduce;
import org.drools.mapreduce.core.util.DroolsHelper;
import org.kie.api.runtime.KieSession;

public class DroolsReducer implements Reducer<String, String, String, String> {
	private final String kieBase;

	public DroolsReducer() {
		this(null);
	}

	public DroolsReducer(String kieBase) {
		this.kieBase = kieBase;
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
			KieSession kieSession = DroolsHelper.createKieSession(this.kieBase);
			kieSession.insert(runningReduce);
			Entry entry = new Entry(key.toString(), nextValue.toString());
			kieSession.insert(entry);
			kieSession.getAgenda().getAgendaGroup("reducer-rules").setFocus();
			kieSession.fireAllRules();
			kieSession.dispose();
		}
		
		collector.collect(runningReduce.key, runningReduce.value);
	}
}
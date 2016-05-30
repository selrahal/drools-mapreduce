package org.drools.mapreduce.core.impl;

import org.drools.mapreduce.core.api.Reducer;
import org.drools.mapreduce.core.collector.api.ValueCollector;
import org.drools.mapreduce.core.model.entry.Entry;
import org.drools.mapreduce.core.util.DroolsHelper;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class DroolsReducer implements Reducer {
	private final KieContainer kieContainer;

	public DroolsReducer() {
		this.kieContainer = DroolsHelper.createClasspathKieContainer();
	}

	public void reduce(Entry entry1, ValueCollector collector) {
		if (entry1 == null) {
			return;
		}

		KieSession kieSession = kieContainer.newKieSession();
		kieSession.insert(entry1);
		kieSession.insert(collector);
		DroolsHelper.fireAgendaGroup(kieSession, "reducer-rules");
		kieSession.dispose();
	}
}
package org.drools.mapreduce.core.impl;

import org.drools.mapreduce.core.api.Collector;
import org.drools.mapreduce.core.api.Mapper;
import org.drools.mapreduce.core.model.entry.Entry;
import org.drools.mapreduce.core.util.DroolsHelper;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class DroolsMapper implements Mapper<String, String, String, String>{
	private final KieContainer kieContainer;
	
	public DroolsMapper() {
		this.kieContainer = DroolsHelper.createClasspathKieContainer();
	}
    public void map(String key, String value, Collector<String, String> collector) {
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.setGlobal("collector", collector);
        Entry entry = new Entry(key.toString(), value.toString());
        kieSession.insert(entry);
        DroolsHelper.fireAgendaGroup(kieSession, "mapper-rules");
        kieSession.dispose();
    }
}

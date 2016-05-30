package org.drools.mapreduce.core.impl;

import org.drools.mapreduce.core.api.Mapper;
import org.drools.mapreduce.core.collector.api.EntryCollector;
import org.drools.mapreduce.core.model.entry.Entry;
import org.drools.mapreduce.core.util.DroolsHelper;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class DroolsMapper implements Mapper{
	private final KieContainer kieContainer;
	
	public DroolsMapper() {
		this.kieContainer = DroolsHelper.createClasspathKieContainer();
	}
	
    public void map(Entry entry, EntryCollector collector) {
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.insert(collector);
        kieSession.insert(entry);
        DroolsHelper.fireAgendaGroup(kieSession, "mapper-rules");
        kieSession.dispose();
    }
}

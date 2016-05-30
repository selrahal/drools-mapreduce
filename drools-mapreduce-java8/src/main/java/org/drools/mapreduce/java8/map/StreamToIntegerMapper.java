package org.drools.mapreduce.java8.map;

import java.util.function.Function;

import org.drools.mapreduce.core.util.DroolsHelper;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class StreamToIntegerMapper<I> implements Function<I,Integer>{
	private final KieContainer kieContainer;
	
	public StreamToIntegerMapper() {
		this.kieContainer = DroolsHelper.createClasspathKieContainer();
	}

	public Integer apply(I t) {
		//Java8 Streams just have values, no keys. Oh well
		SingleIntegerValueCollector valueCollector = new SingleIntegerValueCollector();
		KieSession kieSession = kieContainer.newKieSession();
		kieSession.setGlobal("valueCollector", valueCollector);
		kieSession.insert(t);
		DroolsHelper.fireAgendaGroup(kieSession, "mapper-rules");
        return valueCollector.get();
	}

}

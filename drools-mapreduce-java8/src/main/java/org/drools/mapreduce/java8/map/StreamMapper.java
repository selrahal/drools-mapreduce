package org.drools.mapreduce.java8.map;

import java.util.function.Function;

import org.drools.mapreduce.core.api.ValueCollector;
import org.drools.mapreduce.core.util.DroolsHelper;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class StreamMapper<I,O> implements Function<I,O>{
	private final KieContainer kieContainer;
	
	public StreamMapper() {
		this.kieContainer = DroolsHelper.createClasspathKieContainer();
	}

	public O apply(I t) {
		//Java8 Streams just have values, no keys. Oh well
		ValueCollector<O> valueCollector = (ValueCollector<O>) new SingleValueCollector();
		KieSession kieSession = kieContainer.newKieSession();
		kieSession.setGlobal("valueCollector", valueCollector);
		kieSession.insert(t);
		DroolsHelper.fireAgendaGroup(kieSession, "mapper-rules");
        return valueCollector.get();
	}

}

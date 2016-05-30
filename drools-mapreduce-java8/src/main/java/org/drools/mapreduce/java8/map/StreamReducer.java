package org.drools.mapreduce.java8.map;

import java.util.function.BinaryOperator;

import org.drools.mapreduce.core.api.ValueCollector;
import org.drools.mapreduce.core.util.DroolsHelper;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class StreamReducer<I> implements BinaryOperator<I>{
	private final KieContainer kieContainer;
	
	public StreamReducer() {
		this.kieContainer = DroolsHelper.createClasspathKieContainer();
	}

	@Override
	public I apply(I t, I u) {
		//Java8 Streams just have values, no keys. Oh well
		ValueCollector<I> valueCollector = (ValueCollector<I>) new SingleValueCollector();
		valueCollector.collect(u);
		KieSession kieSession = kieContainer.newKieSession();
		kieSession.insert(valueCollector);
		kieSession.insert(t);
		DroolsHelper.fireAgendaGroup(kieSession, "reducer-rules");
        return valueCollector.get();
	}

}

package org.drools.mapreduce.java8.map;

import java.util.function.BinaryOperator;

import org.drools.mapreduce.core.util.DroolsHelper;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class DroolsIntegerReducer implements BinaryOperator<Integer>{
	private final KieContainer kieContainer;
	
	public DroolsIntegerReducer() {
		this.kieContainer = DroolsHelper.createClasspathKieContainer();
	}

	@Override
	public Integer apply(Integer t, Integer u) {
		//Java8 Streams just have values, no keys. Oh well
		SingleIntegerValueCollector valueCollector = new SingleIntegerValueCollector();
		valueCollector.collect(u);
		KieSession kieSession = kieContainer.newKieSession();
		kieSession.insert(valueCollector);
		kieSession.insert(t);
		DroolsHelper.fireAgendaGroup(kieSession, "reducer-rules");
        return (Integer) valueCollector.get();
	}

}

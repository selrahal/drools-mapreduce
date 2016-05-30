package org.drools.mapreduce.core.util;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class DroolsHelper {
	private static KieContainer kieContainer = KieServices.Factory.get().newKieClasspathContainer();

	public static KieSession createKieSession(String... resources) {
		throw new UnsupportedOperationException();
//		return kieContainer.getKieBase(kieBase).newKieSession();
	}
	
	public static KieContainer createClasspathKieContainer() {
		return kieContainer;
	}
	
	public static void fireAgendaGroup(KieSession kieSession, String ruleflowGroup) {
		kieSession.getAgenda().getAgendaGroup(ruleflowGroup).setFocus();
        kieSession.fireAllRules();
	}
}
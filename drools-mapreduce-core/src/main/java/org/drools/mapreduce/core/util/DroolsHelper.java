package org.drools.mapreduce.core.util;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class DroolsHelper {
	private static KieContainer kieContainer = KieServices.Factory.get().newKieClasspathContainer();

	public static KieSession createKieSession(String kieBase) {
		if (kieBase != null) {
			return kieContainer.getKieBase(kieBase).newKieSession();
		} else {
			return kieContainer.getKieBase().newKieSession();
		}
	}
	
}

package org.drools.mapreduce.core;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.drools.mapreduce.core.api.Collector;
import org.drools.mapreduce.core.impl.ArrayBasedCollector;
import org.drools.mapreduce.core.impl.DroolsReducer;
import org.drools.mapreduce.core.model.entry.Entry;
import org.junit.Assert;
import org.junit.Test;

public class TestReducerRules {
	
	@Test
	public void testWordFrequencyReducing() {
		DroolsReducer reducer = new DroolsReducer();
		Collector<String, String> collector = new ArrayBasedCollector();
		List<String> hate = new ArrayList<String>(5);
		for (int i = 0; i < 5 ; i ++)
			hate.add("1");
		reducer.reduce("hate", hate.iterator(), collector);
		
		Iterator<Entry> iterator = ((ArrayBasedCollector)collector).iterator();
		Assert.assertTrue(iterator.hasNext());
		Entry entry = iterator.next();
		Assert.assertEquals("hate", entry.key);
		Assert.assertEquals("5.0",entry.value);
		Assert.assertFalse(iterator.hasNext());
	}
}

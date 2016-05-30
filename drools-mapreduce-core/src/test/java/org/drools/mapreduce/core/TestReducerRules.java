package org.drools.mapreduce.core;


import org.drools.mapreduce.core.collector.api.ValueCollector;
import org.drools.mapreduce.core.collector.impl.IntegerReducerResult;
import org.drools.mapreduce.core.impl.DroolsReducer;
import org.drools.mapreduce.core.model.entry.IntegerEntry;
import org.junit.Assert;
import org.junit.Test;

public class TestReducerRules {
	
	@Test
	public void testWordFrequencyReducing() {
		DroolsReducer reducer = new DroolsReducer();
		ValueCollector collector = new IntegerReducerResult();
		
		reducer.reduce(new IntegerEntry("hate", 1), collector);
		reducer.reduce(new IntegerEntry("hate", 1), collector);
		reducer.reduce(new IntegerEntry("hate", 1), collector);
		reducer.reduce(new IntegerEntry("hate", 1), collector);
		reducer.reduce(new IntegerEntry("hate", 1), collector);
		
		Integer value = ((IntegerReducerResult)collector).getInt();
		String key = ((IntegerReducerResult)collector).getKey();
		Assert.assertEquals("hate", key);
		Assert.assertEquals((Integer) 5, value);
		
	}
}

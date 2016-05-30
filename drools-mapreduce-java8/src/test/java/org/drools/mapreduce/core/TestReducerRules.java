package org.drools.mapreduce.core;


import java.util.Arrays;
import java.util.List;

import org.drools.mapreduce.java8.map.DroolsIntegerReducer;
import org.junit.Assert;
import org.junit.Test;

public class TestReducerRules {
	
	@Test
	public void testWordFrequencyReducing() {
		
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8);
		Integer sum = numbers.stream().reduce(new DroolsIntegerReducer()).get();
		
		Assert.assertEquals((Integer) 36, (Integer) sum);
	}
}

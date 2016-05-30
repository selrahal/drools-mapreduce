package org.drools.mapreduce.core;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.drools.mapreduce.java8.map.StreamMapper;
import org.junit.Assert;
import org.junit.Test;

public class TestMapperRules {
	
	@Test
	public void testWordFrequencyMapping() {

		List<String> quotes = Arrays.asList("Haters", "gonna","hate","hate","hate","hate","hate",
				"Got","nothing","in","my","brain",
				"I","stay","out","too","late");
		List<Integer> wordCounts = quotes.stream().map(new StreamMapper<String, Integer>()).collect(Collectors.toList());
		
		Assert.assertEquals(quotes.size(), wordCounts.size());
		for (int index = 0; index < quotes.size(); index++) {
			Assert.assertEquals((Integer) quotes.get(index).length(), (Integer) wordCounts.get(index));
		}
	}
}

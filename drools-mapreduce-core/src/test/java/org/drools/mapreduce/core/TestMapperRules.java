package org.drools.mapreduce.core;

import java.util.Iterator;

import org.drools.mapreduce.core.api.Collector;
import org.drools.mapreduce.core.impl.ArrayBasedCollector;
import org.drools.mapreduce.core.impl.DroolsMapper;
import org.drools.mapreduce.core.model.entry.Entry;
import org.junit.Assert;
import org.junit.Test;

public class TestMapperRules {
	
	@Test
	public void testWordFrequencyMapping() {
		DroolsMapper mapper = new DroolsMapper();
		Collector<String, String> collector = new ArrayBasedCollector();
		mapper.map("0", "Haters gonna hate hate hate hate hate", collector);
		mapper.map("1", "Got nothing in my brain", collector);
		mapper.map("2", "I stay out too late", collector);
		
		Iterator<Entry> iterator = ((ArrayBasedCollector)collector).iterator();
		Assert.assertTrue(iterator.hasNext());
		int size = 0;
		while (iterator.hasNext()) {
			size++;
			Entry intermediateEntry = iterator.next();
			Assert.assertEquals(intermediateEntry.value, "1");
		}
		Assert.assertEquals(17, size);
	}
}

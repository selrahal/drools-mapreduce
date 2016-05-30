package org.drools.mapreduce.core;

import java.util.Iterator;

import org.drools.mapreduce.core.collector.api.EntryCollector;
import org.drools.mapreduce.core.collector.impl.StringCollector;
import org.drools.mapreduce.core.impl.DroolsMapper;
import org.drools.mapreduce.core.model.entry.StringEntry;
import org.junit.Assert;
import org.junit.Test;

public class TestMapperRules {
	
	@Test
	public void testWordFrequencyMapping() {
		DroolsMapper mapper = new DroolsMapper();
		EntryCollector collector = new StringCollector();
		mapper.map(new StringEntry("0", "Haters gonna hate hate hate hate hate"), collector);
		mapper.map(new StringEntry("1", "Got nothing in my brain"), collector);
		mapper.map(new StringEntry("2", "I stay out too late"), collector);
		
		Iterator<StringEntry> iterator = ((StringCollector)collector).iterator();
		Assert.assertTrue(iterator.hasNext());
		int size = 0;
		while (iterator.hasNext()) {
			size++;
			StringEntry intermediateEntry = iterator.next();
			Assert.assertEquals(intermediateEntry.value, "1");
		}
		Assert.assertEquals(17, size);
	}
}

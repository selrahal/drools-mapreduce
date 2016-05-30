package org.drools.mapreduce.infinispan.util;

import org.drools.mapreduce.core.collector.api.EntryCollector;
import org.drools.mapreduce.core.model.entry.Entry;
import org.drools.mapreduce.core.model.entry.StringEntry;

public class InfinispanStringCollector implements EntryCollector{
	private final org.infinispan.distexec.mapreduce.Collector<String, String> delegate;
	
	public InfinispanStringCollector(org.infinispan.distexec.mapreduce.Collector<String, String> delegate) {
		this.delegate = delegate;
	}

	public void collect(String key, String value) {
		delegate.emit(key, value);
	}

	public void collect(Entry entry) {
		if (!(entry instanceof StringEntry)) {
			throw new IllegalArgumentException("Entry should be StringEntry! " + entry.getClass());
		}
		
		StringEntry stringEntry = (StringEntry) entry;
		this.collect(stringEntry.key, stringEntry.value);
	}
}
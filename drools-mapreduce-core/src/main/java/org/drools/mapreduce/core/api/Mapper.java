package org.drools.mapreduce.core.api;

import org.drools.mapreduce.core.collector.api.EntryCollector;
import org.drools.mapreduce.core.model.entry.Entry;

public interface Mapper {
	public void map(Entry entry, EntryCollector output);
}
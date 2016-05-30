package org.drools.mapreduce.core.collector.api;

import org.drools.mapreduce.core.model.entry.Entry;

public interface EntryCollector {
	public void collect(Entry entry);
}
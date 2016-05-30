package org.drools.mapreduce.core.collector.api;

import org.drools.mapreduce.core.model.entry.Entry;

public interface ValueCollector {
	public void collect(Entry value);
	public Entry get();
}
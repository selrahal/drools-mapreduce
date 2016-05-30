package org.drools.mapreduce.core.api;

import org.drools.mapreduce.core.collector.api.ValueCollector;
import org.drools.mapreduce.core.model.entry.Entry;

public interface Reducer{
	public void reduce(Entry entry, ValueCollector output);
}
package org.drools.mapreduce.core.api;

public interface ValueCollector {
	public void collect(Object value);
	public Object get();
}
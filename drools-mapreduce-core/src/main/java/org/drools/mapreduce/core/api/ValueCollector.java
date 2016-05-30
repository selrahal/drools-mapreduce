package org.drools.mapreduce.core.api;

public interface ValueCollector<V> {
	public void collect(V value);
	public V get();
}
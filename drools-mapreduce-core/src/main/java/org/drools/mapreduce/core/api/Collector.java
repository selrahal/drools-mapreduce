package org.drools.mapreduce.core.api;

public interface Collector<K,V> {
	public void collect(K key, V value);
}
package org.drools.mapreduce.core.api;

public interface Mapper<K1, V1, K2, V2> {
	public void map(K1 key, V1 value, Collector<K2, V2> output);
}
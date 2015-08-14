package org.drools.mapreduce.core.api;

import java.util.Iterator;

public interface Reducer<K2, V2, K3, V3> {
	public void reduce(K2 key, Iterator<V2> values, Collector<K3, V3> output);
}
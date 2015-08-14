package org.drools.mapreduce.infinispan.util;

import org.drools.mapreduce.core.api.Collector;

public class InfinispanCollector implements Collector<String, String>{
	private final org.infinispan.distexec.mapreduce.Collector<String, String> delegate;
	
	public InfinispanCollector(org.infinispan.distexec.mapreduce.Collector<String, String> delegate) {
		this.delegate = delegate;
	}

	public void collect(String key, String value) {
		delegate.emit(key, value);
	}
}
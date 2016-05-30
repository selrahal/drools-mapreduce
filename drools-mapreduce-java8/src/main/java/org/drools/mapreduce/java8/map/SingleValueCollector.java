package org.drools.mapreduce.java8.map;

import org.drools.mapreduce.core.api.ValueCollector;

public class SingleValueCollector implements ValueCollector<Integer>{
	private Integer holder;

	public void collect(Integer value) {
		holder = value;
	}
	
	public Integer get() {
		return holder;
	}

}

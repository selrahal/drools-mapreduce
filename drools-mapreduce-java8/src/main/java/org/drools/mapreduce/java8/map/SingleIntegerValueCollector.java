package org.drools.mapreduce.java8.map;

public class SingleIntegerValueCollector {
	private Integer holder;

	public void collect(Integer value) {
		holder = value;
	}
	
	public Integer get() {
		return holder;
	}

}

package org.drools.mapreduce.java8.map;

public class SingleStringValueCollector {
	private String holder;

	public void collect(String value) {
		holder = value;
	}
	
	public String get() {
		return holder;
	}

}

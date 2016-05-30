package org.drools.mapreduce.core.collector.impl;

import org.drools.mapreduce.core.collector.api.ValueCollector;
import org.drools.mapreduce.core.model.entry.Entry;
import org.drools.mapreduce.core.model.entry.IntegerEntry;

public class IntegerReducerResult implements ValueCollector {
	private IntegerEntry holding;
	
	public IntegerReducerResult() {
		this.holding = new IntegerEntry("", 0);
	}
	
	public IntegerReducerResult(IntegerEntry initialValue) {
		this.holding = initialValue;
	}
	
	public void collect(String key, Integer value) {
		this.collect(new IntegerEntry(key, value));
	}

	public void collect(IntegerEntry value) {
		this.holding = value;
	}
	
	public Entry get() {
		return this.holding;
	}

	public void collect(Entry value) {
		if (!(value instanceof IntegerEntry)) {
			throw new IllegalArgumentException("Value should be IntegerEntry! " + value.getClass());
		}
		
		this.collect((IntegerEntry)value);
	}

	public Integer getInt() {
		return this.holding.value;
	}
	
	public String getKey() {
		return this.holding.key;
	}
}

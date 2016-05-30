package org.drools.mapreduce.core.collector.impl;

import org.drools.mapreduce.core.collector.api.ValueCollector;
import org.drools.mapreduce.core.model.entry.Entry;
import org.drools.mapreduce.core.model.entry.StringEntry;

public class StringReducerResult implements ValueCollector {
	private StringEntry holding;
	
	public StringReducerResult() {
		this.holding = new StringEntry("", "");
	}
	
	public StringReducerResult(StringEntry initialValue) {
		this.holding = initialValue;
	}
	
	public void collect(String key, String value) {
		this.collect(new StringEntry(key, value));
	}

	public void collect(StringEntry value) {
		this.holding = value;
	}
	
	public Entry get() {
		return this.holding;
	}

	public void collect(Entry value) {
		if (!(value instanceof StringEntry)) {
			throw new IllegalArgumentException("Value should be IntegerEntry! " + value.getClass());
		}
		
		this.collect((StringEntry)value);
	}

	public String getString() {
		return this.holding.value;
	}
	
	public String getKey() {
		return this.holding.key;
	}
}

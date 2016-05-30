package org.drools.mapreduce.core.model.entry;

public class IntegerEntry implements Entry{
	public String key;
	public Integer value;
	
	public IntegerEntry(String key, Integer value) {
		this.key = key;
		this.value = value;
	}

	@Override
	public String toString() {
		return "Entry [key=" + key + ", value=" + value + "]";
	}
}

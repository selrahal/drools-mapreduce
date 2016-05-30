package org.drools.mapreduce.core.model.entry;

public class StringEntry implements Entry{
	public String key;
	public String value;
	
	public StringEntry(String key, String value) {
		this.key = key;
		this.value = value;
	}

	@Override
	public String toString() {
		return "Entry [key=" + key + ", value=" + value + "]";
	}
}

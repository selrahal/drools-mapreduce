package org.drools.mapreduce.core.model.entry;

public class RunningReduce {
	public String key;
	public String value;
	
	public RunningReduce(String key, String value) {
		this.key = key;
		this.value = value;
	}

	@Override
	public String toString() {
		return "RunningReduce [key=" + key + ", value=" + value + "]";
	}
	
}

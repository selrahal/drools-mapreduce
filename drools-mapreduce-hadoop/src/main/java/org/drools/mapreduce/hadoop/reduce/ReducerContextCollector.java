package org.drools.mapreduce.hadoop.reduce;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.drools.mapreduce.core.collector.api.ValueCollector;
import org.drools.mapreduce.core.model.entry.Entry;
import org.drools.mapreduce.core.model.entry.StringEntry;

public class ReducerContextCollector implements ValueCollector {
	private final Reducer<Text, Text, Text, Text>.Context context;
	
	public ReducerContextCollector(Reducer<Text, Text, Text, Text>.Context context) {
		this.context = context;
	}

	public void collect(String key, String value) {
		try {
			context.write(new Text(key), new Text(value));
		} catch (IOException e) {
			throw new RuntimeException("Failed to collect " + key + "," + value, e);
		} catch (InterruptedException e) {
			throw new RuntimeException("Failed to collect " + key + "," + value, e);
		}
	}

	public void collect(Entry value) {
		if (!(value instanceof StringEntry)) {
			throw new IllegalArgumentException("Entry should be StringEntry! "+ value.getClass());
		}
		
		StringEntry stringEntry = (StringEntry) value;
		this.collect(stringEntry.key, stringEntry.value);
	}

	public Entry get() {
		throw new UnsupportedOperationException();
	}

}

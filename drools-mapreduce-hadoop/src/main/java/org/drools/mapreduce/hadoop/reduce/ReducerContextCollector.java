package org.drools.mapreduce.hadoop.reduce;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.drools.mapreduce.core.api.Collector;

public class ReducerContextCollector implements Collector<String, String> {
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

}

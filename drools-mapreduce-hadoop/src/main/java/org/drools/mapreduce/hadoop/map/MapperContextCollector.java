package org.drools.mapreduce.hadoop.map;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.drools.mapreduce.core.api.Collector;

public class MapperContextCollector implements Collector<String, String> {
	private final Mapper<LongWritable, Text, Text, Text>.Context context;
	
	public MapperContextCollector(Mapper<LongWritable, Text, Text, Text>.Context context) {
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

package org.drools.mapreduce.hadoop.map;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.drools.mapreduce.core.collector.api.EntryCollector;
import org.drools.mapreduce.core.model.entry.Entry;
import org.drools.mapreduce.core.model.entry.StringEntry;

public class MapperContextCollector implements EntryCollector {
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

	public void collect(Entry entry) {
		if (!(entry instanceof StringEntry)) {
			throw new IllegalArgumentException("Entry should be StringEntry! "+ entry.getClass());
		}
		
		StringEntry stringEntry = (StringEntry) entry;
		this.collect(stringEntry.key, stringEntry.value);
	}

}

package org.drools.mapreduce.core.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.drools.mapreduce.core.api.Collector;
import org.drools.mapreduce.core.model.entry.Entry;

public class ArrayBasedCollector implements Collector<String, String>{
	private List<Entry> entries = new ArrayList<Entry>();
	
	public void collect(Entry entry) {
		entries.add(entry);
	}
	
	public void collect(String key, String value) {
		this.collect(new Entry(key, value));
	}
	
	public Iterator<Entry> iterator() {
		return entries.iterator();
	}
}

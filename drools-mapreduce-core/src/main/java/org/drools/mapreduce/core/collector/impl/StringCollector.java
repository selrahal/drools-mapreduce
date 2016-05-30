package org.drools.mapreduce.core.collector.impl;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.drools.mapreduce.core.collector.api.EntryCollector;
import org.drools.mapreduce.core.model.entry.Entry;
import org.drools.mapreduce.core.model.entry.StringEntry;

public class StringCollector implements EntryCollector {
	private final List<StringEntry> entries;
	
	public StringCollector() {
		this.entries = new LinkedList<StringEntry>();
	}
	
	public void collect(String key, String value) {
		this.collect(new StringEntry(key, value));
	}
	
	public Iterator<StringEntry> iterator() {
		return entries.iterator();
	}

	public void collect(Entry entry) {
		if (!(entry instanceof StringEntry)) {
			throw new IllegalArgumentException("Entry should be a StringEntry! " + entry.getClass());
		}
		
		entries.add((StringEntry) entry);
	}
}

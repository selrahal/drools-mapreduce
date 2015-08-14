package org.drools.mapreduce.hadoop.util;

import java.util.Iterator;

import org.apache.hadoop.io.Text;

public class TextToStringIterator implements Iterator<String>{
	private final Iterator<Text> delegate;
	
	public TextToStringIterator(Iterable<Text> delegate) {
		this.delegate = delegate.iterator();
	}

	public boolean hasNext() {
		return delegate.hasNext();
	}

	public String next() {
		return delegate.next().toString();
	}
}
package org.drools.mapreduce.infinispan.reduce;

import java.util.Iterator;

import org.drools.mapreduce.core.collector.api.ValueCollector;
import org.drools.mapreduce.core.collector.impl.StringReducerResult;
import org.drools.mapreduce.core.impl.DroolsReducer;
import org.drools.mapreduce.core.model.entry.StringEntry;
import org.infinispan.distexec.mapreduce.Reducer;

public class InfinispanDroolsReducer implements Reducer<String, String> {
    /** The serialVersionUID */
    private static final long serialVersionUID = 1901016598354633256L;

    public String reduce(String key, Iterator<String> iter) {
    	ValueCollector collector = new StringReducerResult();
    	DroolsReducer reducer = new DroolsReducer();
    	while (iter.hasNext()) {
    		String nextValue = iter.next();
    		reducer.reduce(new StringEntry(key, nextValue), collector);	
    	}
    	
    	return ((StringReducerResult) collector).getString();
    }
 }
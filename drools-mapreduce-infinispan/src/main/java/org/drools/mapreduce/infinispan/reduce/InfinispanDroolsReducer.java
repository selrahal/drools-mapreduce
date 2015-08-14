package org.drools.mapreduce.infinispan.reduce;

import java.util.Iterator;

import org.drools.mapreduce.core.api.Collector;
import org.drools.mapreduce.core.impl.ArrayBasedCollector;
import org.drools.mapreduce.core.impl.DroolsReducer;
import org.infinispan.distexec.mapreduce.Reducer;

public class InfinispanDroolsReducer implements Reducer<String, String> {
    /** The serialVersionUID */
    private static final long serialVersionUID = 1901016598354633256L;

    public String reduce(String key, Iterator<String> iter) {
    	Collector<String, String> collector = new ArrayBasedCollector();
    	DroolsReducer reducer = new DroolsReducer();
    	reducer.reduce(key, iter, collector);
    	return ((ArrayBasedCollector) collector).iterator().next().value;
    }
 }
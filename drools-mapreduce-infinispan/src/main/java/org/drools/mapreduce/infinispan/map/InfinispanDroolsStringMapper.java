package org.drools.mapreduce.infinispan.map;

import org.drools.mapreduce.core.collector.api.EntryCollector;
import org.drools.mapreduce.core.impl.DroolsMapper;
import org.drools.mapreduce.core.model.entry.StringEntry;
import org.drools.mapreduce.infinispan.util.InfinispanStringCollector;
import org.infinispan.distexec.mapreduce.Collector;
import org.infinispan.distexec.mapreduce.Mapper;

public class InfinispanDroolsStringMapper implements Mapper<String, String, String, String> {
	/** The serialVersionUID */
	private static final long serialVersionUID = -5943370243108735560L;

	public void map(String key, String value, Collector<String, String> c) {
		EntryCollector collector = new InfinispanStringCollector(c);
        DroolsMapper mapper = new DroolsMapper();
        mapper.map(new StringEntry(key, value), collector);
	}
}
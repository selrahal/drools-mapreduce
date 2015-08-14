package org.drools.mapreduce.infinispan.map;

import org.drools.mapreduce.core.impl.DroolsMapper;
import org.drools.mapreduce.infinispan.util.InfinispanCollector;
import org.infinispan.distexec.mapreduce.Collector;
import org.infinispan.distexec.mapreduce.Mapper;

public class InfinispanDroolsMapper implements Mapper<String, String, String, String> {
	/** The serialVersionUID */
	private static final long serialVersionUID = -5943370243108735560L;

	public void map(String key, String value, Collector<String, String> c) {
		org.drools.mapreduce.core.api.Collector<String, String> collector = new InfinispanCollector(c);
        DroolsMapper mapper = new DroolsMapper();
        mapper.map(key.toString(), value.toString(), collector);
	}
}
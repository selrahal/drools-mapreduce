package org.drools.mapreduce.hadoop.map;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.drools.mapreduce.core.collector.api.EntryCollector;
import org.drools.mapreduce.core.impl.DroolsMapper;
import org.drools.mapreduce.core.model.entry.StringEntry;

public class HadoopDroolsMapper extends Mapper<LongWritable, Text, Text, Text>{

    @Override
    public void map(LongWritable key, Text value, Context output) throws IOException, InterruptedException {
        EntryCollector collector = new MapperContextCollector(output);
        DroolsMapper mapper = new DroolsMapper();
        mapper.map(new StringEntry(key.toString(), value.toString()), collector);
    }
}

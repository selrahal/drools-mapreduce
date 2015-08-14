package org.drools.mapreduce.hadoop.map;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.drools.mapreduce.core.api.Collector;
import org.drools.mapreduce.core.impl.DroolsMapper;

public class HadoopDroolsMapper extends Mapper<LongWritable, Text, Text, Text>{

    @Override
    public void map(LongWritable key, Text value, Context output) throws IOException, InterruptedException {
        Collector<String, String> collector = new MapperContextCollector(output);
        DroolsMapper mapper = new DroolsMapper();
        mapper.map(key.toString(), value.toString(), collector);
    }
}

package org.drools.mapreduce.hadoop.reduce;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.drools.mapreduce.core.api.Collector;
import org.drools.mapreduce.core.impl.DroolsReducer;
import org.drools.mapreduce.hadoop.util.TextToStringIterator;

public class HadoopDroolsReducer extends Reducer<Text, Text, Text, Text> {

    @Override
    public void reduce(Text key, Iterable<Text> values, Context output)
            throws IOException, InterruptedException {
    	Collector<String, String> collector = new ReducerContextCollector(output);
    	DroolsReducer reducer = new DroolsReducer();
    	reducer.reduce(key.toString(), new TextToStringIterator(values), collector);
    }
}
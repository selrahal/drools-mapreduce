package org.drools.mapreduce.hadoop.reduce;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.drools.mapreduce.core.collector.api.ValueCollector;
import org.drools.mapreduce.core.impl.DroolsReducer;
import org.drools.mapreduce.core.model.entry.StringEntry;

public class HadoopDroolsReducer extends Reducer<Text, Text, Text, Text> {

    @Override
    public void reduce(Text key, Iterable<Text> values, Context output)
            throws IOException, InterruptedException {
    	ValueCollector collector = new ReducerContextCollector(output);
    	DroolsReducer reducer = new DroolsReducer();
    	Iterator<Text> iterator = values.iterator();
    	while (iterator.hasNext()) {
    		Text nextValue = iterator.next();
    		reducer.reduce(new StringEntry(key.toString(), nextValue.toString()), collector);
    	}
    	
    }
}
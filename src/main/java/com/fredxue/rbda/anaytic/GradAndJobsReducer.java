package com.fredxue.rbda.anaytic;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * Created by fredxue on 10/11/2017.
 */
public class GradAndJobsReducer extends Reducer<Text,Text,Text,Text> {

    @Override
    public void reduce(Text key, Iterable<Text> values, Context context)
            throws IOException, InterruptedException {
        for (Text value : values) {
            context.write(key, value);
        }
    }
}

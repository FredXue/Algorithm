package com.fredxue.rbda.class2;
import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/**
 * Created by fredxue on 20/09/2017.
 */
public class WordCountReducer
        extends Reducer<Text,IntWritable,Text,IntWritable>{

    @Override
    public void reduce(Text key, Iterable<IntWritable> values, Context context)
            throws IOException, InterruptedException{
        int sum = 0;
        for( IntWritable value : values){
            sum = value.get() + sum;
        }
        context.write(key, new IntWritable(sum));
    }
}

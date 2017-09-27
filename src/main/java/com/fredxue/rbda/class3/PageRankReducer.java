package com.fredxue.rbda.class3;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Created by fredxue on 20/09/2017.
 */
public class PageRankReducer
        extends Reducer<Text,Text,Text,Text>{

    @Override
    public void reduce(Text key, Iterable<Text> values, Context context)
            throws IOException, InterruptedException{
        double sum = 0;
        String target = "";
        for( Text value : values){
            String line = value.toString();
            if (line.contains(".")) {
                sum = sum + Double.valueOf(line);
            } else {
                target = line;
            }
        }

        NumberFormat formatter = new DecimalFormat("#0.000000");

        context.write(key, new Text(target + String.valueOf(formatter.format(sum))));
    }
}

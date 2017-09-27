package com.fredxue.rbda.class3;

/**
 * Created by fredxue on 20/09/2017.
 */

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class PageRankMapper
        extends Mapper<LongWritable, Text, Text, Text>{


    public void map(LongWritable key, Text value, Context context)
            throws IOException, InterruptedException{
        String[] pages = value.toString().split(" ");
        double initPR = Long.valueOf(pages[pages.length-1]);

        for(int i = 1; i < pages.length-1; i++) {
            context.write (new Text(pages[i]), new Text(String.valueOf(Math.floor((initPR*100000000)/(pages.length-2))/100000000)) );
        }
        context.write(new Text(pages[0]), new Text(value.toString().substring(2,(pages.length-1)*2)));
    }
}

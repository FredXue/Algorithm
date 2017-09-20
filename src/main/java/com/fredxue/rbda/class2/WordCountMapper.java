package com.fredxue.rbda.class2;

/**
 * Created by fredxue on 20/09/2017.
 */

import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordCountMapper
        extends Mapper<LongWritable, Text, Text, IntWritable>{

    private static final int MISSING = 9999;

    private static final String[] KEY_WORDS = {"hackathon", "Dec", "Chicago", "Java"};

    public void map(LongWritable key, Text value, Context context)
            throws IOException, InterruptedException{
        String line = value.toString().toLowerCase();

        for(String str : KEY_WORDS) {
            if (line.contains(str.toLowerCase())) {
                context.write (new Text(str), new IntWritable (1));
            }
        }
    }
}

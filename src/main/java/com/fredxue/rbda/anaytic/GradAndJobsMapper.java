package com.fredxue.rbda.anaytic;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * Created by fredxue on 10/11/2017.
 */
public class GradAndJobsMapper extends Mapper<LongWritable, Text, Text, Text> {

    public void map(LongWritable key, Text value, Context context)
            throws IOException, InterruptedException{
        String[] cols = value.toString().split(",");

        double cnt = 0.0;
        StringBuilder cleanedData = new StringBuilder("");
        for(int i = 0; i < cols.length; i++) {
            if(cleanedData.length() > 0) cleanedData.append(",");
            cleanedData.append(cols[i]);
        }
        context.write(new Text(String.valueOf(cnt)), new Text(cleanedData.toString()));
    }
}

package com.fredxue.rbda.project;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * Created by fredxue on 10/11/2017.
 */
public class HRDataMapper  extends Mapper<LongWritable, Text, Text, Text> {

    public void map(LongWritable key, Text value, Context context)
            throws IOException, InterruptedException{
        String[] headers = "satisfaction_level,last_evaluation,number_project,average_montly_hours,time_spend_company,Work_accident,left,promotion_last_5years,sales,salary".split(".");
        String[] cols = value.toString().split(",");
        if(cols[0].equals(headers[0])) return;

        for(int i = 0; i < cols.length; i++) {
            context.write(new Text(headers[i]), new Text(cols[i]));
        }
    }
}

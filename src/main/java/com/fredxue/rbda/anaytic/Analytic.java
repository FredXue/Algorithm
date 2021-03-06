package com.fredxue.rbda.anaytic;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/**
 * Created by fredxue on 10/11/2017.
 */
public class Analytic {
    public static void main (String[] args) throws Exception{
        if (args.length != 2) {
            System.err.println("Usage: Analytic <input path> <output path>");
            System.exit(-1);
        }

        Job job = new Job();
        Configuration conf = job.getConfiguration();
        conf.set("mapred.textoutputformat.separator", ",");

        job.setJarByClass(Analytic.class);
        job.setJobName("Data Analysis");

        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        job.setMapperClass(GradAndJobsMapper.class);
        job.setReducerClass(GradAndJobsReducer.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);
        System.exit(job.waitForCompletion(true)? 0:1);
    }
}

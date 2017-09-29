package com.fredxue.rbda.class3;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/**
 * Created by fredxue on 27/09/2017.
 */
public class IteratePageRank {
    public static void main (String[] args) throws Exception{
        if (args.length != 2) {
            System.err.println("Usage: MaxTemperature <input path> <output path>");
            System.exit(-1);
        }
        int i =2;
        while (i>=0) {
            Job job = new Job();
            Configuration conf = job.getConfiguration();
            conf.set("mapred.textoutputformat.separator", " ");

            job.setJarByClass(PageRank.class);
            job.setJobName("Page Rank Job" + i);

            FileInputFormat.addInputPath(job, new Path((i==2?args[0]:args[1]+(i+1))));
            FileOutputFormat.setOutputPath(job, new Path(args[1] + (i==0?"":i)));

            job.setMapperClass(PageRankMapper.class);
            job.setReducerClass(PageRankReducer.class);

            job.setOutputKeyClass(Text.class);
            job.setOutputValueClass(Text.class);
            job.waitForCompletion(true);
            i--;
        }
        System.exit(0);
    }
}

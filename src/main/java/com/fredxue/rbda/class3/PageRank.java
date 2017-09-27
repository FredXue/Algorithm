package com.fredxue.rbda.class3;

import com.fredxue.rbda.class2.WordCount;
import com.fredxue.rbda.class2.WordCountMapper;
import com.fredxue.rbda.class2.WordCountReducer;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/**
 * Created by fredxue on 26/09/2017.
 */
public class PageRank {
    public static void main (String[] args) throws Exception{
        if (args.length != 2) {
            System.err.println("Usage: MaxTemperature <input path> <output path>");
            System.exit(-1);
        }
        Job job = new Job();
        job.setJarByClass(PageRank.class);
        job.setJobName("Page Rank");

        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        job.setMapperClass(PageRankMapper.class);
        job.setReducerClass(PageRankReducer.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);
        System.exit(job.waitForCompletion(true)? 0:1);
    }
}

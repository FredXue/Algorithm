package com.fredxue.rbda.class3;

/**
 * Created by fredxue on 28/09/2017.
 */
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Iterator;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;
import org.apache.hadoop.mapred.TextInputFormat;
import org.apache.hadoop.mapred.TextOutputFormat;


public class PageRank1 {

    public static class Map extends MapReduceBase implements Mapper <LongWritable, Text, Text, Text> {
        Text id;
        public void map(LongWritable key, Text value, OutputCollector<Text, Text> output, Reporter reporter) throws IOException {

            String line = value.toString();

            String[] values = line.split(" ");


            Text t = new Text(values[0]);
            value.set(values[1]);

            String[] ids = value.toString().split(" ");

            DoubleWritable pr = new DoubleWritable(Double.valueOf(ids[ids.length]));

            String url="_";

            for (int i = 0; i < (ids.length-1); i++) {
                url+=ids[i]+" ";
                id = new Text(ids[i]);

                output.collect(id, new Text((values[0])+" "+(String.valueOf(Double.valueOf(ids[ids.length])/ (ids.length - 1))+"")));

            }


            output.collect(t, new Text(url));
        }

    }


    public static class Reduce extends MapReduceBase implements Reducer<Text, Text, Text, Text>{

        private Double pr;

        public void reduce(Text key, Iterator<Text> values, OutputCollector<Text, Text> out, Reporter reporter){
            double sum = 0;
            String url = "";

            while(values.hasNext()) {

                String a = values.next().toString();
                if(!a.contains("_")){

                    sum += Double.valueOf(a);
                }else{
                    url= a.replace("_", " ");
                }

            }
            pr=sum;
            try {
                out.collect(key, new Text(url+""+pr));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) throws Exception {

        NumberFormat nf = new DecimalFormat("00");

        if (args.length != 2) {
            System.err.println("Usage:pagerank <in><out>");
            System.exit(2);
        }

        JobConf conf = new JobConf(PageRank.class);

        conf.setOutputKeyClass(Text.class);
        conf.setOutputValueClass(Text.class);

        conf.setInputFormat(TextInputFormat.class);
        conf.setOutputFormat(TextOutputFormat.class);

        FileInputFormat.setInputPaths(conf, new Path(args[0]));
        FileOutputFormat.setOutputPath(conf, new Path(args[1]));

        conf.setMapperClass(Map.class);
        conf.setReducerClass(Reduce.class);

        JobClient.runJob(conf);

    }
}


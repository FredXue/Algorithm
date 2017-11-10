package com.fredxue.rbda.project;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * Created by fredxue on 10/11/2017.
 */
public class HRDataReducer extends Reducer<Text,Text,Text,Text> {

    @Override
    public void reduce(Text key, Iterable<Text> values, Context context)
            throws IOException, InterruptedException {
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        int len = 0;
        for (Text value : values) {
           String val = value.toString();
           if(StringUtils.isNumeric(val)) {
               min = Math.min(Double.valueOf(val), min);
               max = Math.max(Double.valueOf(val), max);
           } else {
               len = Math.max(val.length(), len);
           }
        }

        String res = (min == Double.MAX_VALUE?"-":min) + "," + (max == Double.MIN_VALUE?"-":max)+"," + len;

        /** key min max stringLength */
        context.write(key, new Text(res));
    }
}

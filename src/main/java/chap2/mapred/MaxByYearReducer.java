package chap2.mapred;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

//See here that the reducer has a list of values for a key, this is after shuffle and sort phase

public class MaxByYearReducer implements Reducer<Text, IntWritable, Text, IntWritable> {

  public void reduce(Text text, Iterator<IntWritable> iterator, OutputCollector<Text, IntWritable> outputCollector,
      Reporter reporter) throws IOException {
    int max = 0;
    while (iterator.hasNext()) {
      max = Math.max(iterator.next().get(), max);
    }
    outputCollector.collect(text, new IntWritable(max));
  }

  public void close() throws IOException {

  }

  public void configure(JobConf jobConf) {

  }
}

package chap2.mapred;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class MaxByYearMapper implements Mapper<LongWritable, Text, Text, IntWritable> {

  public void map(LongWritable longWritable, Text text, OutputCollector<Text, IntWritable> outputCollector, Reporter reporter)
      throws IOException {

    System.out.println("This is the offset being read in mapper " + longWritable);

    String line = text.toString();
    outputCollector.collect(new Text(line.split(",")[0]), new IntWritable(Integer.parseInt(line.split(",")[1])));
  }

  public void close() throws IOException {

  }

  public void configure(JobConf jobConf) {

  }
}

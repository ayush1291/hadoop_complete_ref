package chap2.mapred;

import java.io.IOException;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.TextInputFormat;
import org.apache.hadoop.mapred.TextOutputFormat;

public class JobStarter {

  public static void main(String[] args) throws IOException {
    System.out.println("Here ****** ");
    JobConf jobConf = new JobConf(JobStarter.class);
    jobConf.setJobName("Max Temp By Year Job");

    jobConf.setJarByClass(MaxByYearMapper.class);

    jobConf.setOutputKeyClass(Text.class);
    jobConf.setOutputValueClass(IntWritable.class);

    jobConf.setMapperClass(MaxByYearMapper.class);
    jobConf.setReducerClass(MaxByYearReducer.class);
    // jobConf.setCombinerClass(MaxByYearReducer.class);

    jobConf.setInputFormat(TextInputFormat.class);
    jobConf.setOutputFormat(TextOutputFormat.class);

    FileInputFormat.addInputPath(jobConf, new Path("file:///Users/ayushkumar/Downloads/htcr"));
    FileOutputFormat.setOutputPath(jobConf, new Path("/Users/ayushkumar/Downloads/htcr1/output"));

    JobClient.runJob(jobConf);
  }
}

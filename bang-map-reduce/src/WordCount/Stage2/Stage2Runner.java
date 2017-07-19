package WordCount.Stage2;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;

import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.SequenceFileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

public class Stage2Runner {
public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
	Configuration conf=new Configuration();
	Job job=Job.getInstance(conf,"Word Count stage 2");
	
	job.setJarByClass(Stage2Runner.class);
	job.setMapOutputKeyClass(IntWritable.class);
	job.setMapOutputValueClass(Text.class);
	
	job.setOutputKeyClass(Text.class);
	job.setOutputValueClass(IntWritable.class);
	
	job.setMapperClass(FlipMapper.class);
	job.setReducerClass(FlipReducer.class);
	
	job.setInputFormatClass(SequenceFileInputFormat.class);
	job.setOutputFormatClass(TextOutputFormat.class);
	
	FileInputFormat.setInputPaths(job, new Path(args[0]));
	FileOutputFormat.setOutputPath(job, new Path(args[1]));
	
	System.exit(job.waitForCompletion(true)?0:1);
	
}
}

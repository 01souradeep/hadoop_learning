package compositekeys;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class Runner {
	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		Configuration conf = new Configuration();
		Job job = Job.getInstance(conf, "composite keys");
		job.setJarByClass(Runner.class);
		job.setMapperClass(GroupMapper.class);
		job.setReducerClass(GroupReducer.class);

		job.setOutputKeyClass(Country.class);
		job.setOutputValueClass(IntWritable.class);

		FileInputFormat.setMaxInputSplitSize(job, 10);
		FileInputFormat.setMinInputSplitSize(job, 100);
		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		System.exit(job.waitForCompletion(true) ? 0 : 1);

	}

}

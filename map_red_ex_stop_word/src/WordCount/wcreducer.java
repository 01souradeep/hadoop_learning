package WordCount;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Reducer.Context;

public class wcreducer extends Reducer<Text, IntWritable,Text , IntWritable> {

	public void reduce(Text word,Iterable<IntWritable> values,Context context) throws IOException, InterruptedException{
		int sum=0;
		for(IntWritable val:values){
			sum=sum+val.get();
		}
		context.write(word, new IntWritable(sum));
	} 
}

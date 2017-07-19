package WordCount;

import java.io.IOException;

import org.apache.hadoop.*;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
public class SumReducer extends Reducer<Text, IntWritable, Text, IntWritable>{

	public void reduce(Text word,Iterable<IntWritable> values,Context context) throws IOException, InterruptedException{
		int sum=0;
		for(IntWritable val:values){
			sum=sum+val.get();
		}
		context.write(word, new IntWritable(sum));
	}
}

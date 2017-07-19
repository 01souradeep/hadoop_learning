package WordCount.Stage2;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

import org.apache.hadoop.*;

public class FlipReducer extends Reducer<IntWritable, Text, Text, IntWritable>{
	public void reduce(IntWritable count,Iterable<Text> words,Context context) throws IOException, InterruptedException{
		int posCount=-count.get();
		for(Text word:words){
			context.write(word, new IntWritable(posCount));
			
		}
		
	}

}

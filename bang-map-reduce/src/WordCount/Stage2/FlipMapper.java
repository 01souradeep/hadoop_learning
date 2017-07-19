package WordCount.Stage2;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;

import java.io.IOException;

import org.apache.hadoop.*;
public class FlipMapper extends Mapper<Text,IntWritable,IntWritable, Text> {
	public void map(Text word,IntWritable count,Context context) throws IOException, InterruptedException{
		int negCount=-count.get();
	    context.write(new IntWritable(negCount), word);
		
	}

}

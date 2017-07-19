package WordCount;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.map.WrappedMapper;

public class WordMapper extends Mapper<LongWritable, Text, Text,IntWritable> {
	public void map(LongWritable offset,Text text,Context context) throws IOException, InterruptedException{
		String line=text.toString();
		StringTokenizer tokens=new StringTokenizer(line);
		while(tokens.hasMoreTokens()){
			context.write(new Text(tokens.nextToken()), new IntWritable(1));
		}
		
	}

}

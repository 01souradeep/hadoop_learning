package wordCount.Stage1;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import com.cloudera.com.amazonaws.auth.policy.conditions.StringCondition.StringComparisonType;

public class WordMapper extends Mapper<LongWritable, Text, Text, IntWritable>{
	public void map(LongWritable offset,Text line,Context context) throws IOException, InterruptedException{
		String lines=line.toString();
		StringTokenizer tokens=new StringTokenizer(lines);
		while(tokens.hasMoreTokens()){
			context.write(new Text(tokens.nextToken()), new IntWritable(1));
			
		}
		
	}

}

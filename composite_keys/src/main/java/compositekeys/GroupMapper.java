package compositekeys;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class GroupMapper extends Mapper<LongWritable, Text, Country, IntWritable> {
	Country cntry = new Country();
	Text cntText = new Text();
	Text stateText = new Text();
	IntWritable populat = new IntWritable();

	@Override
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

		String line = value.toString();
		String[] keyvalue = line.split(",");
		cntText.set(new Text(keyvalue[0]));
		stateText.set(keyvalue[1]);
		try {
			populat.set(Integer.parseInt(keyvalue[keyvalue.length - 1]));
		} catch (NumberFormatException e) {
			System.out.println("Integer Not Found");
			return;
		}
		Country cntry = new Country(cntText, stateText);

		context.write(cntry, populat);

	}
}

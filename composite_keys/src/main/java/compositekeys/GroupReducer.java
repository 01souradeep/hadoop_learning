package compositekeys;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Reducer;

public class GroupReducer extends Reducer<Country, IntWritable, Country, IntWritable> {
	@Override
	public void reduce(Country key, Iterable<IntWritable> values, Context context)
			throws IOException, InterruptedException {

		int cnt = 0;
		for (IntWritable val : values) {
			cnt = cnt + val.get();
		}
		context.write(key, new IntWritable(cnt));

	}

}

package WordCount;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.map.WrappedMapper;
public class wcmapper extends Mapper<LongWritable, Text, Text,IntWritable > {
	public void map(LongWritable offset,Text line,Context context) throws IOException, InterruptedException{
		String lines=line.toString();
		
		StringTokenizer tokens=new StringTokenizer(lines);
		while(tokens.hasMoreTokens()){
			String s=tokens.nextToken();
                    if(!stopword(s)){		
				context.write(new Text(s),new IntWritable(1));
                    }
                    else{
                    	
			continue;
			
		}
	}
	}
 private boolean stopword(String s){
	String[] sw={"The","is","a","and","of"};
	for(int i=0;i<5;i++){
		if(s.equalsIgnoreCase(sw[i])){
			return true;
		}
	}
	return false;
	}
	
	 
 }



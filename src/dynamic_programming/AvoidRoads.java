package dynamic_programming;

import java.util.HashMap;
import java.util.StringTokenizer;

public class AvoidRoads {
	public static void main(String[] args){
		AvoidRoads a = new AvoidRoads();
		int width = 2;
		int height = 2;
		String[] bad =  {"1 2 2 2", "1 1 2 1"}
;
		System.out.println(a.numWays(width, height, bad));
		
	}
	
	public long numWays(int width, int height, String[] bad){
		return numWays(0,0,width, height, bad);
	}
	
//	HashMap<String,Long> dic = new HashMap<String,Long>();
	public long numWays(int sw, int sh, int tw, int th, String[] bad){
		//String x = sw + " " + sh + " " + tw + " " + th;
		//if(dic.containsKey(x)) return dic.get(x);
		if(sw == tw && sh == th)return 0;
		if(sw + 1 == tw && sh + 1 == th && (!isBad(sw,sh,sw+1,sh,bad)&& !isBad(sw+1,sh,sw+1,sh+1,bad)||(!isBad(sw,sh,sw,sh+1,bad)&&!isBad(sw,sh+1,sw+1,sh+1,bad)))) return 2;
		if(sw == tw){
			long answer = numWays(sw,sh+1, tw, th, bad);
		//	dic.put(x, answer);
			return answer;
		}
		if(sh == th){
			long answer = numWays(sw+1,sh, tw, th, bad);
			//dic.put(x, answer);
			return answer;
		}
		if(isBad(sw, sh, sw, sh+1, bad) && isBad(sw, sh, sw+1, sh, bad)) return 0;
		if(isBad(sw, sh, sw, sh+1, bad)){
			long answer = numWays(sw+1,sh, tw, th, bad);
		//	dic.put(x, answer);
			return answer;
		}
		if(isBad(sw, sh, sw+1, sh, bad)){
			long answer = numWays(sw,sh+1, tw, th, bad);
		//	dic.put(x, answer);
			return answer;
		}
		
		long answer = numWays(sw+1, sh, tw, th, bad)+ numWays(sw, sh+1, tw, th, bad);
	//	dic.put(x,answer);
		return answer;
	}
	
	public boolean isBad(int sw, int sh, int tw, int th, String[] bads){
		
		for(String bad: bads){
			StringTokenizer st = new StringTokenizer(bad);
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());			
			if((a == sw && b == sh && c == tw && d == th) ||(a == tw && b == th && c == sw && d == sh))
				return true;
		}
		return false;
	}
	
	
	

}

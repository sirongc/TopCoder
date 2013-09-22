package dynamic_programming;

import java.util.HashMap;

public class ZigZag {
	public static void main(String[] args){
		ZigZag z = new ZigZag();
		int[] sequence = { 374, 40, 854, 203, 203, 156, 362, 279, 812, 955, 
				600, 947, 978, 46, 100, 953, 670, 862, 568, 188, 
				67, 669, 810, 704, 52, 861, 49, 640, 370, 908, 
				477, 245, 413, 109, 659, 401, 483, 308, 609, 120, 
				249, 22, 176, 279, 23, 22, 617, 462, 459, 244 };
		System.out.println(z.longestZigZag(sequence));
	}
	
	public int longestZigZag(int[] sequence){
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		return longestZigZag(sequence, sequence.length-1, map);
	}
	public int longestZigZag(int[] sequence, int N, HashMap<Integer, Integer> map){
		if(N <= 1){
			map.put(N, N+1);
			return N+1;
		}
		if(map.containsKey(N)) return map.get(N);
		
		int longest = 0;
		for(int i = 0; i < N; i++){
			if(isZigZag(sequence, i, N)) 
				longest = Math.max(longest, longestZigZag(sequence, i, map)+1);
		}
		map.put(N, longest);
		return longest;
	}
	
	public boolean isZigZag(int[] sequence, int i, int N ){
		if(i == 0) return true;
		if(sequence[i] > sequence[i-1] && sequence[i] > sequence[N]) return true;
		if(sequence[i] < sequence[i-1] && sequence[i] < sequence[N]) return true;
		return false;
	}

}

package bfs;

import java.util.ArrayList;
import java.util.HashMap;

public class CaptureThemAll {
	
	public static void main(String[] args){
		 
		 System.out.println(fastKnight("e4","c3","g1"));
	}
	
	public static int fastKnight(String knight, String rook, String queen){
		return Math.min(minStep(knight, rook), minStep(knight, queen)) + minStep(queen, rook);
	}

	//BFS
	private static int minStep(String start, String end) {
		HashMap<String, Integer> stepMap = new HashMap<String, Integer>();
		
		if(start.equals(end)) return 0;
		int step = 1;
		
		ArrayList<String> frontier = new ArrayList<String>();
		frontier.add(start);
		
		while(!frontier.isEmpty()){
			ArrayList<String> next = new ArrayList<String>();
			for(String u: frontier){
				ArrayList<String> allNext = nextLoc(u);
				for(String v: allNext){
					if(!stepMap.containsKey(v)){
						if(v.equals(end)) return step;
						stepMap.put(v, step);
						next.add(v);
					}
				}
			}
			frontier = next;
			step++;
		}
		return -1;
	}

	private static ArrayList<String> nextLoc(String start){
		char c = start.charAt(0);
		char r = start.charAt(1);
		
		ArrayList<String> next = new ArrayList<String>();
		
		if(inBoard((char)(c-2), (char)(r-1))) next.add(""+(char)(c-2)+(char)(r-1));
		if(inBoard((char)(c-2), (char)(r+1))) next.add(""+(char)(c-2)+(char)(r+1));
		if(inBoard((char)(c+2), (char)(r-1))) next.add(""+(char)(c+2)+(char)(r-1));
		if(inBoard((char)(c+2), (char)(r+1))) next.add(""+(char)(c+2)+(char)(r+1));
		if(inBoard((char)(c-1), (char)(r-2))) next.add(""+(char)(c-1)+(char)(r-2));
		if(inBoard((char)(c+1), (char)(r-2))) next.add(""+(char)(c+1)+(char)(r-2));
		if(inBoard((char)(c-1), (char)(r+2))) next.add(""+(char)(c-1)+(char)(r+2));
		if(inBoard((char)(c+1), (char)(r+2))) next.add(""+(char)(c+1)+(char)(r+2));

		return next;	
	}
	
	private static boolean inBoard(char c, char r){
		if(c < 'a' || c > 'h') return false;
		if(r < '1' || r > '8') return false;
		return true;
	}

}

package bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;

public class WordLadderII {
	public static void main(String[] args){
		String start = "hot";
		String end = "ceg";
		String[] dic = {"hot","dot","dog","cog","ceg","eot","eog"};

		/**LinkedList<LinkedList<String>> x = ;Solution(start, end, dic)
		for(LinkedList<String> i: x){
			for(String s: i)
				System.out.print(s + " ");
			System.out.println("");
		}**/
		
		System.out.println(minStep(start, end, dic));
	}
	
	
	public static LinkedList<LinkedList<String>> Solution(String start, String end, String[] dic){
		LinkedList<LinkedList<String>> allPaths = new LinkedList<LinkedList<String>>();
		
		HashMap<String, String> parent = new HashMap<String, String>();
		parent.put(start, null);
		
		Stack<String> s = new Stack<String>();
		s.add(start);
		
		while(!s.isEmpty()){
			String  current = s.pop();
			String nextP;
			if(!parent.containsKey(current)){
//				parent.put(current, nextP);
				nextP = current;
			}
			
			
			
			ArrayList<String> next = nextString(current, dic);
		}
		
		
		
		
		return null;
	}
	
	
	
	//using BFS to find the shortest answers.
	public static int minStep(String start, String end, String[] dic){
		//LinkedList<LinkedList<String>> allPaths = new LinkedList<LinkedList<String>>();
		
		HashSet<String> isVisited = new HashSet<String>();
		isVisited.add(start);
		
	//	HashMap<String, String> parent = new HashMap<String, String>();	
	//	parent.put(start, null);
		int step = 1;
		ArrayList<String> frontier = new ArrayList<String>();//queue
		frontier.add(start);

		while(!frontier.isEmpty()){
			ArrayList<String> allNext = new ArrayList<String>();
			boolean found = false;// determine whether the shortest answers have been found.
			
			for(String u: frontier){
				ArrayList<String> next = nextString(u, dic);	
				for(String v: next){
					if(!isVisited.contains(v)){
						isVisited.add(v);
						
						//parent.put(v, u);
						allNext.add(v);
						
						if(oneCharDiffered(v, end)){
							return step;
						}
							
							/**
							LinkedList<String> path = new LinkedList<String>();
							path.add(end);
							
							String current = v;
							while(parent.get(current) != null){
								path.addFirst(current);
								current = parent.get(current);
							}
							path.addFirst(current);
							allPaths.add(path);
							found = true;**/		
					}	
				}
				
			}
			frontier = allNext;
			step++;
			//if(found == true) return allPaths; //if the shortest step answers have been found, return the paths.
		}	
		return -1;
	}
	
	public static ArrayList<String> nextString(String str, String[] dic){
		ArrayList<String> next = new ArrayList<String>();
		for(String d: dic){
			if(oneCharDiffered(str, d)) next.add(d);
		}
		return next;
	}
	
	public static boolean oneCharDiffered(String str, String dic){
		int length = str.length();
		int count = 0;
		for(int i = 0; i < length; i++){
			if(str.charAt(i) != dic.charAt(i)) count++;
		}
		return count == 1;
	}

}

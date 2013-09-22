package bfs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SmartWordToy {
	
	public static void main(String[] args){

		String start = "zzzz";
		String finish = "aaaa";
		String[] forbid = {"abcdefghijkl abcdefghijkl abcdefghijkl abcdefghijk"};
	//	String[] x = getNextPossible(start, forbid);
		System.out.println(minPresses(start, finish, forbid));
	}
	
	public static int minPresses(String start, String finish, String[] forbid){
		if(start.equals(finish)) return 0;
		
		HashMap<String, Integer> levelMap = new HashMap<String, Integer>();//建一张map，来判断是否读过某个state，若没有则是新的state
		
		LinkedList<String> frontier = new LinkedList<String>();
		frontier.add(start);//在一个queue中存入start state
		
		levelMap.put(start, 0);// the level of the start is 0
		int level = 1;// the next level is 1.
		
		while(frontier.size() != 0){//当queue不为空时
			LinkedList<String> next = new LinkedList<String>();//用来储存所有的next
			for(String f: frontier){//遍历queue里所有的元素
				String[] adj = getNextPossible(f, forbid);
				for(String n: adj){//遍历每个元素的所有next
					if(!levelMap.containsKey(n)){//若以前没读过这个元素，存入levelMap中，若读过，什么都不做。
						if(n.equals(finish)){
							return level; //新state中若有finish state，则返回当前level，就是最小level。
						}
						levelMap.put(n, level);//存入level以表示读过
						next.add(n);//在next中存入这个新元素
					}	
				}	
			}
			frontier = next;//最外延的frontier现在变成所有的next。
			level++;	//增加一层
		}
		return -1;//若便利完了所有state，当中没return过，就说明到不了finish state，返回-1
	}
	
	private static String[] getNextPossible(String str, String[] forbid) {
		String[] allLastFinish = getAllNextPossible(str);
		int length = 0;
		for(String all: allLastFinish){
			if(!isForbid(all, forbid)) length++;
		}
		
		String[] answer = new String[length];
		int i = 0;
		for(String all: allLastFinish){
			if(!isForbid(all, forbid)) answer[i++] = all;
		}
		
		return answer;
	}

	private static String[] getAllNextPossible(String cur) {
		String[] allLast = new String[8];
		allLast[0] = nextChar(cur.charAt(0)) + cur.substring(1);
		allLast[1] = lastChar(cur.charAt(0)) + cur.substring(1);
		
		allLast[2] = ""+ cur.charAt(0) + nextChar(cur.charAt(1)) + cur.substring(2);
		allLast[3] = ""+cur.charAt(0) + lastChar(cur.charAt(1)) + cur.substring(2);
		
		allLast[4] = ""+cur.charAt(0) + cur.charAt(1) + nextChar(cur.charAt(2)) + cur.charAt(3) + "";
		allLast[5] = ""+cur.charAt(0) + cur.charAt(1) + lastChar(cur.charAt(2)) + cur.charAt(3) + "";
		
		allLast[6] = ""+cur.charAt(0) + cur.charAt(1) +  cur.charAt(2) + nextChar(cur.charAt(3)) + "";
		allLast[7] = ""+cur.charAt(0) + cur.charAt(1) +  cur.charAt(2) + lastChar(cur.charAt(3)) + "";
		return allLast;
	}

	private static Character lastChar(char c) {
		if(c == 'a') return 'z';
		return (char)(--c);
	}

	private static Character nextChar(char c) {
		if(c == 'z') return 'a';
		return (char)(++c);
	}

	public static boolean isForbid(String word, String[] forbid){
		for(String f: forbid){
			if(isForbid(word, f))
				return true;
		}
		return false;
	}

	private static boolean isForbid(String word, String forbid) {
		StringTokenizer st = new StringTokenizer(forbid);
		int count = 0;
		int j = 0;
		while(st.hasMoreTokens()){
			boolean f = false;
			String s = st.nextToken();
			for(int i = 0; i < s.length(); i++){
				if(word.charAt(j) == s.charAt(i)){
					f = true;
				}
			}
			j++;
			if(f) count++;
		}
		if(count == 4) return true;
		return false;
	}

}

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
		
		HashMap<String, Integer> levelMap = new HashMap<String, Integer>();//��һ��map�����ж��Ƿ����ĳ��state����û�������µ�state
		
		LinkedList<String> frontier = new LinkedList<String>();
		frontier.add(start);//��һ��queue�д���start state
		
		levelMap.put(start, 0);// the level of the start is 0
		int level = 1;// the next level is 1.
		
		while(frontier.size() != 0){//��queue��Ϊ��ʱ
			LinkedList<String> next = new LinkedList<String>();//�����������е�next
			for(String f: frontier){//����queue�����е�Ԫ��
				String[] adj = getNextPossible(f, forbid);
				for(String n: adj){//����ÿ��Ԫ�ص�����next
					if(!levelMap.containsKey(n)){//����ǰû�������Ԫ�أ�����levelMap�У���������ʲô��������
						if(n.equals(finish)){
							return level; //��state������finish state���򷵻ص�ǰlevel��������Сlevel��
						}
						levelMap.put(n, level);//����level�Ա�ʾ����
						next.add(n);//��next�д��������Ԫ��
					}	
				}	
			}
			frontier = next;//�����ӵ�frontier���ڱ�����е�next��
			level++;	//����һ��
		}
		return -1;//��������������state������ûreturn������˵��������finish state������-1
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

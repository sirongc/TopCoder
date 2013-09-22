package how_to_find_a_solution;

import java.util.LinkedList;

public class BusinessTasks {
	public static void main(String[] args){
		String[] list = {"zlqamum","yjsrpybmq","tjllfea","fxjqzznvg","nvhekxr","am","skmazcey","piklp",
				"olcqvhg","dnpo","bhcfc","y","h","fj","bjeoaxglt","oafduixsz","kmtbaxu",
				"qgcxjbfx","my","mlhy","bt","bo","q"};
		int n = 9000000;
		System.out.println(getTask(list, n));
	}
	
	
	public static String getTask(String[] list, int n){
		LinkedList<String> l = new LinkedList<String>();
		for(String str: list)
			l.add(str);
		int index = 0;
		while(l.size() > 1){
			if(index == l.size()){
				index = nextIndex(0, l.size(), n);
				l.remove(index);
			}
			else{
				index = nextIndex(index,l.size(), n);
				l.remove(index);
			}
		}
		return l.getFirst();
	}
	
	public static int nextIndex(int index, int size, int n){
		if(index < size-n+1) return index + n-1;
		else return  (index +n-1)%size;
	}
	

}

package dissect_problem;

import java.util.*;
//backtracking algorithm，其实就是iteration + 递归，遍历所有可能性，然后用static变量来一个个对比，得到最好值。

public class BridgeCrossing {
	public static int best = Integer.MAX_VALUE;
	public static void main(String[] args){
		int[] times = {1, 2, 3, 50, 99, 100};
		System.out.print(minTime(times));
	}
	
	public static int minTime(int[] times){
		best = Integer.MAX_VALUE;
		if(times.length == 1) return times[0];
		return bt(new State(times));
	}	
	
	//bt（bestTime）这个方法中，过桥是有各种方法的，但对面拿回手电筒其实最优方案只有一个，就是让速度最快，数值最小的人过来，
    //因此没必要像topcoder例子中那样分两种情况讨论，一个state和下一个state之间间隔就是一个来回，本质就是通过遍历过桥的2个人的所有排列组合。
	public static int bt(State orig){
		ArrayList<Integer> left = orig.left;
		int length = left.size();
		if(length == 2) return Math.max(left.get(0), left.get(1));
		
		for(int i = 0; i < length-1; i++){
			for(int j = i+1; j < length; j++){
				State newState = new State(orig);
				int goToRightTime = Math.max(newState.left.get(i), newState.left.get(j));//过桥的时间
				newState.right.add(newState.left.get(i));
				newState.right.add(newState.left.get(j));
				newState.left.remove(j);
				newState.left.remove(i);
				Collections.sort(newState.right);
				int goToLeftTime = newState.right.get(0);//对面一个人回来的时间
				newState.left.add(goToLeftTime);
				newState.right.remove(0);
				newState.time += goToRightTime + goToLeftTime;//这是关键，新State中的time必须更新。
				int possibleBest =  orig.time + goToRightTime + goToLeftTime + bt(newState);
				//这个可能的时间 = 当前状态已经用掉的时间  + 过桥时间 + 对面一人回来时间 + 新状态开始到所有人过完桥的最佳时间。
				best = (possibleBest < best? possibleBest : best);
			}
		}
		return best;
	}
	
	public static int smallestInArrayList(ArrayList<Integer> A){
		int min = Integer.MAX_VALUE;
		for(int a: A) min = (a < min? a : min);
		return min;
	}
}

class State{
	public ArrayList<Integer> left = new ArrayList<Integer>();
	public ArrayList<Integer> right = new ArrayList<Integer>();
	int time;
	
	public State(State A){
		left = new ArrayList<Integer>(A.left);
		right = new ArrayList<Integer>(A.right);
		time = A.time;
	}
	public State(int[] times){
		time = 0;
		Arrays.sort(times);
		for(int time: times) left.add(time);
	}
}
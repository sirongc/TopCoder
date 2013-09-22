package dissect_problem;

import java.util.*;
//backtracking algorithm����ʵ����iteration + �ݹ飬�������п����ԣ�Ȼ����static������һ�����Աȣ��õ����ֵ��

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
	
	//bt��bestTime����������У��������и��ַ����ģ��������û��ֵ�Ͳ��ʵ���ŷ���ֻ��һ�����������ٶ���죬��ֵ��С���˹�����
    //���û��Ҫ��topcoder����������������������ۣ�һ��state����һ��state֮��������һ�����أ����ʾ���ͨ���������ŵ�2���˵�����������ϡ�
	public static int bt(State orig){
		ArrayList<Integer> left = orig.left;
		int length = left.size();
		if(length == 2) return Math.max(left.get(0), left.get(1));
		
		for(int i = 0; i < length-1; i++){
			for(int j = i+1; j < length; j++){
				State newState = new State(orig);
				int goToRightTime = Math.max(newState.left.get(i), newState.left.get(j));//���ŵ�ʱ��
				newState.right.add(newState.left.get(i));
				newState.right.add(newState.left.get(j));
				newState.left.remove(j);
				newState.left.remove(i);
				Collections.sort(newState.right);
				int goToLeftTime = newState.right.get(0);//����һ���˻�����ʱ��
				newState.left.add(goToLeftTime);
				newState.right.remove(0);
				newState.time += goToRightTime + goToLeftTime;//���ǹؼ�����State�е�time������¡�
				int possibleBest =  orig.time + goToRightTime + goToLeftTime + bt(newState);
				//������ܵ�ʱ�� = ��ǰ״̬�Ѿ��õ���ʱ��  + ����ʱ�� + ����һ�˻���ʱ�� + ��״̬��ʼ�������˹����ŵ����ʱ�䡣
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
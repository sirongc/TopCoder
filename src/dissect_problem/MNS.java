package dissect_problem;

import java.util.ArrayList;
import java.util.HashSet;

public class MNS {
	
	
	public static int combos(int[] numbers){
		int count = 0;
		HashSet<ArrayList<Integer>> answerList = new HashSet<ArrayList<Integer>>();
		
		ArrayList<ArrayList<Integer>> indexLists = getAllCom(9);
		for(ArrayList<Integer> indexList: indexLists){
			int[] newList = new int[9];		
			for(int i = 0; i < 9; i++){
				newList[indexList.get(i)] = numbers[i];
			}
			
			ArrayList<Integer> answer = new ArrayList<Integer>();
			for(int num: newList){
				answer.add(num);
			}
			
			if(isMagic(newList) && !answerList.contains(answer)){
				count++;
				answerList.add(answer);
			}
		}
		return count;
	}
	
	public static boolean isMagic(int[] A){
		if ((A[0] + A[1] + A[2]) != (A[3] + A[4] + A[5])) return false;
		else if ((A[0] + A[1] + A[2]) != (A[6] + A[7] + A[8])) return false;
		else if ((A[0] + A[1] + A[2]) != (A[0] + A[3] + A[6])) return false;
		else if ((A[0] + A[1] + A[2]) != (A[1] + A[4] + A[7])) return false;
		else if ((A[0] + A[1] + A[2]) != (A[2] + A[5] + A[8])) return false;
		else return true;
	}
	
	public static ArrayList<ArrayList<Integer>> getAllCom(int N){
		if(N == 1){
			ArrayList<Integer> newList = new ArrayList<Integer>();
			newList.add(0);
			ArrayList<ArrayList<Integer>> firstAnswer = new ArrayList<ArrayList<Integer>>();
			firstAnswer.add(newList);
			return firstAnswer;
		}
		
		ArrayList<ArrayList<Integer>> old = getAllCom(N-1);
		ArrayList<ArrayList<Integer>> newList = new ArrayList<ArrayList<Integer>>();
		for(ArrayList<Integer> oldList: old){
			for(int i = 0; i < N; i++){
				ArrayList<Integer> temp = new ArrayList<Integer> (oldList);
				temp.add(i, N-1);
				newList.add(temp);
			}		
		}
		return newList;
	}
	
	public static void main(String[] args){
		int[] A = {1,2,6,6,6,4,2,6,4};
		int[] B = {1,2,3,3,2,1,2,2,2};

		System.out.print(combos(B));
		
		
	}

}

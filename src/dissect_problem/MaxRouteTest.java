package dissect_problem;

public class MaxRouteTest {//此算法是错的。。。
	public static void main(String[] args){
		int[][] A = {
				{1,3,2},
				{2,4,8},
				{9,5,7}
				
		};
		
		System.out.println(getSolution(A));
		
	}
	
	public static int getSolution(int[][] A){
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < A.length; i++){
			min = Math.min(min, getTempSolution(getNewA(A,i)));
		}
		return min;
	}
	
	public static int getTempSolution(int[][] A){
		boolean[] isSet = new boolean[A[0].length];
		for(int i = 0; i < isSet.length; i++) isSet[i] = false;
	
		int min = Integer.MIN_VALUE;
		for(int i = 0; i < A.length; i++){
			int[] temp = getMin(A[i], isSet);
			isSet[temp[1]] = true;
			min = Math.max(min, temp[0]);
		}	
		return min;
	}
	
	public static int[][] getNewA(int[][] A, int i){
		int[][] newA = new int[A.length][A[0].length];
		for(int j = i; j < A.length; j++){
			for(int k = 0; k < A[0].length; k++){
				newA[j-i][k] = A[j][k];
			}
		}
		for(int j = 0; j < i; j++){
			for(int k = 0; k < A[0].length; k++){
				newA[A.length-i+j][k] = A[j][k];
			}
		}
		return newA;
	}

	
	
	public static int[] getMin(int[] A, boolean isSet[]){//first index is min value, second is the index of the min value.
		int min = Integer.MAX_VALUE;
		int j = -1;
		for(int i = 0; i < A.length; i++){
			if(A[i] < min && !isSet[i]){
				min = A[i];
				j = i;
			}
		}
		int[] answer = new int[2];
		answer[0] = min;
		answer[1] = j;
		return answer;
	}

}

package srm;

public class TeamsSelection {
	private final boolean ONE = true;
	private final boolean TWO = false;
	public static void main(String[] args){
		TeamsSelection ts = new TeamsSelection();
		int[] preference1 = {6, 1, 5, 2, 3, 4};
		int[] preference2 = {1, 6, 3, 4, 5, 2};
		System.out.println(ts.simulate(preference1, preference2));
		
		
	}
	
	
	public String simulate(int[] preference1, int[] preference2){
		int length = preference1.length;
		boolean[] picked = new boolean[length];
		char[] teamTurn = new char[length];
		boolean turn = ONE;
		int minIndex;
		for(int i = 0; i < length; i++){
			if(turn == ONE){
				minIndex = getMinIndex(preference1, picked);
				teamTurn[minIndex] = '1';
				turn = TWO;
				picked[minIndex] = true;
			}	
			else if(turn == TWO){
				minIndex = getMinIndex(preference2, picked);
				teamTurn[minIndex] = '2';
				turn = ONE;
				picked[minIndex] = true;
			}		
			
		}
		return new String(teamTurn);
	}
	
	private int getMinIndex(int[] A, boolean[] picked){
		int min = Integer.MAX_VALUE;
		int index = -1;
		for(int i = 0; i < A.length; i++){
			if(min > A[i] && !picked[i]){
				min = A[i];
				index = i;
			}
		}
		return index;
	}
	
}

package srm;

public class PiecewiseLinearFunction {
	
	
	public int maximumSolutions(int[] Y){
		int temp = 1;
		int max = 0;
		int[] range = getRange(Y[0], Y[1]);
		for(int i = 1; i < Y.length-1; i++){
			range = getRange(Y[i], Y[i+1], range);
			if(range[0] != Integer.MIN_VALUE){
				temp++;
			}else{
				range = getRange(Y[i], Y[i+1]);
				max = Math.max(max, temp);
				temp = 1;
			}
		}
		return max;
	}
	
	private int[] getRange(int x, int y){
		int[] A = new int[2];
		if(x < y){
			A[0] = x;
			A[1] = y;
		}else{
			A[0] = y;
			A[1] = x;
		}
		return A;
	}
	
	private int[] getRange(int x, int y, int[] range){
		int[] finalRange = new int[2];
		int[] nextRange = getRange(x, y);
		if(nextRange[1] < range[0] || nextRange[0] > range[1]) {
			finalRange[0] = Integer.MIN_VALUE;
		}else{
			finalRange[0] = Math.max(range[0], nextRange[0]);
			finalRange[1] = Math.min(range[1], nextRange[1]);
		}
		return finalRange;
	}
	

}

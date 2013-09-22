package srm;

public class PiecewiseLinearFunctionDiv2 {
	public static void main(String[] args){
		int[] Y = {-178080289, -771314989, -237251715, -949949900, -437883156, -835236871, -316363230, -929746634, -671700962};
		int[] query = {-673197622, -437883156, -251072978, 221380900, -771314989, -949949900, -910604034, -671700962, -929746634, -316363230};
		PiecewiseLinearFunctionDiv2 p = new PiecewiseLinearFunctionDiv2();
		int[] answer = p.countSolutions(Y, query);
		for(int i: answer) System.out.print(" " + i);
		
		//System.out.println((-65000)*(-65000));
				
		
	}
	public int[] countSolutions(int[] Y, int[] query){
		int[] counts = new int[query.length];
		for(int i = 0; i < query.length; i++){
			counts[i] = countSolution(Y, query[i]);
		}
		return counts;
	}
	
	public int countSolution(int[] Y, int query){
		int count = 0;
		for(int i = 0; i < Y.length-1; i++){
			if(Y[i] == query) count++;
			if(isBetween(Y[i], Y[i+1], query)) count++;
		}
		if(Y[Y.length-1] == query) count++;
		return count;
	}
	
	private boolean isBetween(int i, int j, int query){
		if(query < i && query > j) return true;
		else if(query > i && query < j) return true;
		return false;
	}

}

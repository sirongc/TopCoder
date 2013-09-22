package dissect_problem;

import java.util.HashMap;

public class ReccurenceRelation {
	
	public static void main(String[] args){
		int[] coefficients = {901,492,100};
		int[] initial = {-6,-15,-39};
		int N = 0;
		System.out.println(moduloTen(coefficients, initial, N));
	}
	
	
	public static long moduloTen(int[] coefficients, int[] initial, int N){
		long Xn = Xn(coefficients,initial, N);
		if(Xn >= 0) return Xn%10;
		else return (10-((-Xn)%10))%10;
	}
	
	public static long Xn(int[] coefficients, int[] initial, int N){
		map.clear();
		return getXn(coefficients, initial, N);
	}
	
	static HashMap<Integer, Long> map = new HashMap<Integer, Long>();
	public static long getXn(int[] coefficients, int[] initial, int N){
		if(map.containsKey(N)) return map.get(N);
		
		long result = 0;
		int k = coefficients.length;
		if(N < k) {
			map.put(N, (long) initial[N]);
			return initial[N];
		}

		for(int i = 0; i < k; i++){
			result += coefficients[k-1-i] * getXn(coefficients,initial,N-1-i);
		}
		map.put(N, result);
		return result;
	}

}

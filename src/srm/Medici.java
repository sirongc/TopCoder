package srm;

import java.util.Arrays;

public class Medici {
	public static void main(String[] args){
		Medici m = new Medici();
		int[] fame = { 20, 30, 50 };
		int[] fortune = { 60, 80, 40 };
		int[] secrets = { 40, 30, 50 };
		System.out.println(m.winner(fame, fortune, secrets));
	}
	
	public int winner(int[] fame, int[] fortune, int[] secrets){
		int[] best = new int[fame.length];
		for(int i = 0; i < best.length; i++){
			best[i] = Math.min(fame[i], Math.min(fortune[i], secrets[i]));
		}

		int minIndex = -1;
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < best.length; i++){
			if(max < best[i]){
				max = best[i];
				minIndex = i;
			}else if(max == best[i]) minIndex = -1;
		}
		return minIndex;
		
	}

}

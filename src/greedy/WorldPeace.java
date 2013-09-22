package greedy;

import java.util.Arrays;

public class WorldPeace {
	
	public static void main(String[] args){
		WorldPeace w = new WorldPeace();
		int k = 4;
		int[] countries = { 4,4,4,4,4 };
		System.out.println(w.numGroups(k, countries));
		
	}
	
	
	public long numGroups(int k, int[] countries){
		d_sort(countries);
		int group = 0;
		while(countries[k-1] != 0){
			for(int i = 0; i < k; i++){
				countries[i]--;
			}
			group++;
			d_sort(countries);
		}
		return group;
	}
	
	public void d_sort(int[] countries){
		Arrays.sort(countries);
		for(int i = 0; i < countries.length/2; i++){
			int temp = countries[i];
			countries[i] = countries[countries.length - i - 1];
			countries[countries.length-i-1] = temp;
		}
	}

}

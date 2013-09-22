package srm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;



public class Apothecary {
	
	public static void main(String[] args){
		Apothecary a = new Apothecary();
		int[] balance = a.balance(2016);
		for(int i: balance)
			System.out.println(i);
	}
	
	
	public int getThree(int N){
		int j = 1;
		for(int i = 0; i < N; i++){
			j *= 3;
		}
		return j;
	}
	public int[] balance(int W){
		ArrayList<Integer> balance = new ArrayList<Integer>();
		HashSet<Integer> used = new HashSet<Integer>();
		int left = W;
		int right = 0;
		while(left != right){
			if(left < right){	
				int add = nearInt(right - left, used);
				left += add;
				balance.add(-add);
				used.add(add);
			}else{
				int add = nearInt(left - right, used);
				right += add;
				balance.add(add);
				used.add(add);
			}
		}
		
		int[] b = new int[balance.size()];
		for(int i = 0; i < b.length; i++){
			b[i] = balance.get(i);
		}
		Arrays.sort(b);
		
		return b;
	}
	
	public int nearInt(int W, HashSet<Integer> set){
		int i = 1;
		while(i < W){
			i *= 3;
		}
		
		int right = i;
		int left = i/3;
		while(set.contains(right)){
			right *= 3;
		}
		while(set.contains(left) && left != 0){
			left /= 3;
		}
		if(left == 0) return right;
		else if(right-W > W-left) return left;
		else return right;
	}

}

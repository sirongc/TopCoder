package dynamic_programming;

import java.util.Arrays;

public class FlowerGarden {
	public static void main(String[] args){
		FlowerGarden f = new FlowerGarden();
		int[] height = {1,2,3,4,5,6};
		int[] bloom = {1,3,1,3,1,3};
		int[] wilt = {2,4,2,4,2,4};
		
		
		int[] order = f.getOrdering(height, bloom, wilt);
		for(int i: order)
			System.out.println(i);
	}

	public int[] getOrdering(int[] height, int[] bloom, int[] wilt){
		Flower[] flowers = new Flower[height.length];
		for(int i = 0; i < height.length; i++){
			flowers[i] = new Flower(height[i], bloom[i], wilt[i]);
		}
		Arrays.sort(flowers);
		int[] order = new int[height.length];
		for(int i = 0; i < flowers.length; i++){
			order[i] = flowers[i].height;
		}
		return order;
	}
		
	private class Flower implements Comparable{
		public int height;
		public int bloom;
		public int wilt;
		
		public Flower(int height, int bloom, int wilt){
			this.height = height;
			this.bloom = bloom;
			this.wilt = wilt;
		}
		
		public int compareTo(Object o) {
			Flower that = (Flower) o;
			if(this.wilt < that.bloom || that.wilt < this.bloom){
				if(this.height > that.height) return -1;
				else return 1;
			}
			else{
				if(this.height < that.height) return -1;
				else return 1;
			}
		}
	}
		
}

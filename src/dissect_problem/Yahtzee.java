package dissect_problem;

public class Yahtzee {
	
	public static void main(String[] args){
		int[] a = 	{2, 6, 3, 3, 5};
		System.out.println(maxPoints(a));
	}
	
	public static int maxPoints(int[] toss){
		int[] points = new int[6];
		for(int i = 0; i < toss.length; i++)
			points[toss[i]-1] += toss[i];
			
		int max = 0;
		for(int point: points)
			max = Math.max(max, point);
		
		return max;
	}
}

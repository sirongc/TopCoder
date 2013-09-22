package srm;

public class JumpFurther {
	public static void main(String[] args){
		int N = 1313;
		int badStep = 5858;
		System.out.println(furthest(N, badStep));
	}

	
	public static int furthest(int N, int badStep){
		int sum = 0;
		for(int i = 1; i <= N; i++){
			if(sum != badStep) sum+= i;
			else
				sum += i-1;
		}
		return sum;
	}
	
	

}

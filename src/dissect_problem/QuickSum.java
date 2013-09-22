package dissect_problem;

public class QuickSum {
	public static void main(String[] args){
	//	int[] plus = {1,1};
	//	String number = "111";
	//	System.out.println(result(plus, number));
		int com = 1;
		for(int i = 0; i < 10; i++){
			com *=2;
		}
	//	System.out.println(Integer.toBinaryString(com-1));
		
		
		
		//01010 = 2+16 = 18
		String numbers = "0220120200";
		int sum = 63;
		System.out.println(minSums(numbers,sum));
	}
	
	
	public static int minSums(String numbers, int sum){
		if(numbers.length() == 1)
			return (Integer.parseInt(numbers)==sum? sum:-1);
		
		int minSum = Integer.MAX_VALUE;
		int[] plus = new int[numbers.length()-1];
		int com = 1;
		for(int i = 0; i < numbers.length()-1; i++){
			com *= 2;
		}
		
		for(int i = 0; i < com; i++){
			String per = getBinaryString(i,plus.length);
			plus = initPlus(per, plus);
			if(result(plus, numbers)== sum){
				minSum = Math.min(getPlusNum(plus), minSum);
			}
		}
		if(minSum == Integer.MAX_VALUE) minSum = -1;	
		return minSum;
	}
	
	private static String getBinaryString(int i, int length){
		String per = Integer.toBinaryString(i);
		for(int j = 0; j < length-per.length(); j++){
			per = "0" + per;
		}
		return per;
	}
	
	private static int getPlusNum(int[] plus){
		int num = 0;
		for(int i: plus)
			num +=i;
		return num;
	}
	
	
	private static int[] initPlus(String per, int[] plus) {
		for(int i = 0; i < per.length(); i++){
			if(per.charAt(i) == '0') plus[i] = 0;
			else plus[i] = 1;
		}
		return plus;
	}
	//11111  0110 11+1+11
	public static long result(int[] plus, String number){
		long result = 0;
		String tempNum = number.charAt(0)+"";
		for(int i = 0; i < plus.length; i++){
			if(plus[i]==0){
				tempNum += number.charAt(i+1);
			}else{
				result += Integer.parseInt(tempNum);
				tempNum = number.charAt(i+1)+"";
			}
		}
		result += Long.parseLong(tempNum);
		return result;
	}

}

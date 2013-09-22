package dissect_problem;

public class BettingMoney {
	
	public static void main(String[] args){
		int[] amounts = {100};
		int[] centsPerDollar = {10};
		int finalResult = 0;
		System.out.println(moneyMade(amounts, centsPerDollar, finalResult));
	}
	
	public static int moneyMade(int[] amounts, int[] centsPerDollar, int finalResult){
		int moneyGained = 0;
		for(int i = 0; i < amounts.length; i++){
			if(i == finalResult) continue;
			moneyGained += amounts[i];
		}
		moneyGained *= 100;
		moneyGained -= amounts[finalResult]*centsPerDollar[finalResult];
		return moneyGained;
	}

}

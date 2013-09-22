package greedy;

public class GoldMine {
	public static void main(String[] args){
		GoldMine g = new GoldMine();
		String[] mines = { "050, 000, 000, 000, 000, 050, 000",
				  "050, 000, 000, 000, 000, 050, 000",
				  "050, 000, 000, 000, 000, 050, 000",
				  "050, 000, 000, 000, 000, 050, 000",
				  "050, 000, 000, 000, 000, 050, 000",
				  "050, 000, 000, 000, 000, 050, 000",
				  "050, 000, 000, 000, 000, 050, 000",
				  "050, 000, 000, 000, 000, 050, 000",
				  "050, 000, 000, 000, 000, 050, 000",
				  "050, 000, 000, 000, 000, 050, 000" };
		int miners = 30;
		int[][] B = g.getMap(mines, miners);
		for(int[] b: B){
			for(int c: b){
				System.out.print(c + " ");
			}
			System.out.println("");
		}
		int[] A = g.getAllocation(mines, miners);
		for(int a : A){
			System.out.print(a+" ");
		}	
	}
	
	public int[] getAllocation(String[] mines, int miners){	
		int[] A = new int[mines.length];
		int[][] map = getMap(mines, miners);
		for(int i = 0; i < map[0].length; i++){
			int max = Integer.MIN_VALUE;
			int index = -1;
			for(int j = 0; j < map.length; j++){	
				if(map[j][i] > max){
					max = map[j][i];
					index = j;
				}
			}
			A[index]++;
		}
		return A;
	}
	
	public int[][] getMap(String[]mines, int miners){
		int[][]map = new int[mines.length][miners];
		for(int i = 0; i < map.length; i++){
			for(int j = 1;j <= miners; j++){
				map[i][j-1] = getProfit(mines[i],j);
			}
		}
		
		for(int i = 0; i < map.length; i++){
			for(int j = miners-1; j >= 1; j--){
				map[i][j] -= map[i][j-1];
			}
		}
		return map;
	}

	public int getProfit(String mine, int miners){		
		int[] m = getMine(mine);
		int profit = 0;
		for(int i = 0; i < m.length; i++){
			if(i < miners){
				profit += (new Double(m[i])/100) * (50*i-20*(miners-i));
			}else if(i == miners){
				profit += (new Double(m[i])/100) * miners * 50;
			}else{
				profit += (new Double(m[i])/100)* miners * 60;
			}
		}
		return profit;
	}
	
	public int[] getMine(String mine){
		String[] mString = mine.split(", ");
		int[] m = new int[mString.length];
		for(int i = 0; i < mString.length; i++)
			m[i] = Integer.parseInt(mString[i]);
		
		return m;
	}
	

}

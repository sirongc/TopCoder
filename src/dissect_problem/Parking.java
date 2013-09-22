package dissect_problem;

import java.util.ArrayList;
import java.util.HashSet;

public class Parking {
	public static void main(String[] args){
		Parking p = new Parking();
		String[] park = 		{"PPPPP.....CCCCC"};
		int[][] A = p.minTime(park);
		
		for(int[] i: A){
			for(int j: i){
				System.out.print(j + " ");
			}
			System.out.println("");
		}
		
	
	}

	public int[][] minTime(String[] park){
		ArrayList<Plot> cars = new ArrayList<Plot>();
		ArrayList<Plot> pLots = new ArrayList<Plot>();
		for(int y = 0; y < park.length; y++){
			for(int x = 0; x < park[y].length(); x++){
				if(park[y].charAt(x) == 'C') cars.add(new Plot(x, y));
				if(park[y].charAt(x) == 'P') pLots.add(new Plot(x, y));
			}
		}
	//	if(cars.size() == 0) return 0;
	//	if(cars.size() > pLots.size()) return -1;
		
		int[][] steps = new int[cars.size()][pLots.size()];
		for(int i = 0; i < cars.size(); i++){
			for(int j = 0; j < pLots.size(); j++){
				steps[i][j] = minStep(park, cars.get(i), pLots.get(j));
			}
		}
	  //  if(steps[0][0] == -1) return -1;
		return steps;
	}
	
	public int minStep(String[] park, Plot car, Plot parking){
		HashSet<String> stepMap = new HashSet<String>();
		ArrayList<Plot> frontier = new ArrayList<Plot>();
		frontier.add(car);
		int step = 1;
		while(!frontier.isEmpty()){
			ArrayList<Plot> next = new ArrayList<Plot>();
			for(Plot u: frontier){
				ArrayList<Plot> nextAll = nextStep(park, u);
				for(Plot v: nextAll){
					if(!stepMap.contains(plotString(v))){
						if(v.x == parking.x && v.y == parking.y) return step;
						stepMap.add(plotString(v));
						next.add(v);
					}				
				}
			}
			frontier = next;
			step++;
		}
		return -1;
	}
	
	public String plotString(Plot p){
		return p.x + " " + p.y;
	}
	
	public ArrayList<Plot> nextStep(String[] park, Plot p){
		int x = p.x;
		int y = p.y;
		ArrayList<Plot> nextPlots = new ArrayList<Plot>();
		if(y > 0 && park[y-1].charAt(x) != 'X') nextPlots.add(new Plot(x, y-1));
		if(y < park.length-1 && park[y+1].charAt(x) != 'X') nextPlots.add(new Plot(x, y+1));
		if(x > 0 && park[y].charAt(x-1) != 'X') nextPlots.add(new Plot(x-1, y));
		if(x <park[0].length()-1 && park[y].charAt(x+1) != 'X') nextPlots.add(new Plot(x+1, y));
		return nextPlots;
	}
	
	public static int getSolution(int[][] A){
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < A.length; i++){
			min = Math.min(min, getTempSolution(getNewA(A,i)));
		}
		return min;
	}
	
	public static int getTempSolution(int[][] A){
		boolean[] isSet = new boolean[A[0].length];
		for(int i = 0; i < isSet.length; i++) isSet[i] = false;
	
		int min = Integer.MIN_VALUE;
		for(int i = 0; i < A.length; i++){
			int[] temp = getMin(A[i], isSet);
			isSet[temp[1]] = true;
			min = Math.max(min, temp[0]);
		}	
		return min;
	}
	
	public static int[][] getNewA(int[][] A, int i){
		int[][] newA = new int[A.length][A[0].length];
		for(int j = i; j < A.length; j++){
			for(int k = 0; k < A[0].length; k++){
				newA[j-i][k] = A[j][k];
			}
		}
		for(int j = 0; j < i; j++){
			for(int k = 0; k < A[0].length; k++){
				newA[A.length-i+j][k] = A[j][k];
			}
		}
		return newA;
	}

	
	
	public static int[] getMin(int[] A, boolean isSet[]){//first index is min value, second is the index of the min value.
		int min = Integer.MAX_VALUE;
		int j = -1;
		for(int i = 0; i < A.length; i++){
			if(A[i] < min && !isSet[i]){
				min = A[i];
				j = i;
			}
		}
		int[] answer = new int[2];
		answer[0] = min;
		answer[1] = j;
		return answer;
	}

}
class Plot{
	public int x;
	public int y;
	public Plot(int x, int y){
		this.x = x;
		this.y = y;
	}
}
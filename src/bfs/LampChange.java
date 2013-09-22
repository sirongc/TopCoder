package bfs;

import java.util.ArrayList;
import java.util.HashSet;

public class LampChange {
	public static void main(String[] args){
		int[][] x = {{0,0,1,1,1},
					{0,1,0,1,1},
					{1,0,0,0,1},
					{1,1,0,1,0},
					{1,1,1,0,0}};
		
		System.out.println(bfs(x));
		/**
**/	
		
	
	}
	
	public static String poAll(int[][] A){
		ArrayList<int[][]> B = allNextStep(A);
		String answer = "";
		
		for(int[][] x: B){
			for(int[] a: x){
				for(int y: a)
					answer += y + " ";
				answer += "\n";
			}
			answer += "\n";
		}
		
		
		return answer;
	}
	
	public static int bfs(int[][] A){
		if(allOne(A)) return 0;
		
		HashSet<int[][]> visited = new HashSet<int[][]>();
		ArrayList<int[][]> frontier = new ArrayList<int[][]>();
		frontier.add(A);
		visited.add(A);
		int level = 1;
		while(level <= 6){
			ArrayList<int[][]> allNext = new ArrayList<int[][]>();
			for(int[][] u: frontier){
				ArrayList<int[][]> next = allNextStep(u);
				for(int[][] v: next){
					if(!visited.contains(v)){
						if(allOne(v)) return level;
						visited.add(v);
						allNext.add(v);
					}
				}		
			}
			level++;
			frontier = allNext;
		}
		return -1;
	}
	
	public static boolean allOne(int[][] A){
		for(int i = 0; i < 5; i++){
			for(int j = 0; j < 5; j++){
				if(A[i][j] == 0) return false;
			}
		}
		return true;
	}
	
	public static ArrayList<int[][]> allNextStep(int[][] orig){
		ArrayList<int[][]> next = new ArrayList<int[][]>();
		for(int i = 0; i < 5; i++){
			for(int j = 0; j < 5; j++){
				next.add(nextStep(orig, i, j));
			}
		}
		return next;
	}
	
	public static int[][] nextStep(int[][] B, int x, int y){
		int[][] A = new int[5][5];
		for(int i = 0; i < 5; i++){
			for(int j = 0; j < 5; j++){
				A[i][j] = B[i][j];
			}
		}
		if(x > 0) A[x-1][y] = A[x-1][y]^1;
		if(x < 4) A[x+1][y] = A[x+1][y]^1;
		if(y > 0) A[x][y-1] = A[x][y-1]^1;
		if(y < 4) A[x][y+1] = A[x][y+1]^1;
		A[x][y] ^= 1;
		return A;
	}
	
	

}

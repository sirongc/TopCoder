package bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class grafixMask {
	
	public static void main(String[] args){
		String[] a = {"0 20 399 20", "0 44 399 44", "0 68 399 68", "0 92 399 92",
				 "0 116 399 116", "0 140 399 140", "0 164 399 164", "0 188 399 188",
				 "0 212 399 212", "0 236 399 236", "0 260 399 260", "0 284 399 284",
				 "0 308 399 308", "0 332 399 332", "0 356 399 356", "0 380 399 380",
				 "0 404 399 404", "0 428 399 428", "0 452 399 452", "0 476 399 476",
				 "0 500 399 500", "0 524 399 524", "0 548 399 548", "0 572 399 572",
				 "0 596 399 596", "5 0 5 599", "21 0 21 599", "37 0 37 599",
				 "53 0 53 599", "69 0 69 599", "85 0 85 599", "101 0 101 599",
				 "117 0 117 599", "133 0 133 599", "149 0 149 599", "165 0 165 599",
				 "181 0 181 599", "197 0 197 599", "213 0 213 599", "229 0 229 599",
				 "245 0 245 599", "261 0 261 599", "277 0 277 599", "293 0 293 599",
				 "309 0 309 599", "325 0 325 599", "341 0 341 599", "357 0 357 599",
				 "373 0 373 599", "389 0 389 599"};
		int[] x = sortedAreas(a);
		
		for(int i: x){
			System.out.println(i);
		}
	}
	
	
	public static int[] sortedAreas(String[] rectangles){
		
		boolean[][] bitMap = new boolean[600][400];
		boolean[][] visited = new boolean[600][400];
		
		for(int i = 0; i < 600; i++){
			for(int j = 0; j < 400; j++){
				bitMap[i][j] = false;
				visited[i][j] = false;
			}
		}
		
		for(String block: rectangles){
			StringTokenizer st = new StringTokenizer(block);
			int y1 = Integer.parseInt(st.nextToken());
			int x1 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			for(int i = x1; i <= x2; i++){
				for( int j = y1; j <= y2; j++){
					bitMap[i][j] = true;
				}	
			}
		}
		
		ArrayList<Integer> areas = new ArrayList<Integer>();
		int unBlockAreas = 0;
		for(int x = 0; x < 600; x++){
			for(int y = 0; y < 400; y++){
				int area = 0;
				Plot start = new Plot(x, y);
				visited[x][y] = true;
				ArrayList<Plot> frontier = new ArrayList<Plot>();
				frontier.add(start);
				while(!frontier.isEmpty()){
					ArrayList<Plot> allNext = new ArrayList<Plot>();
					for(Plot u: frontier){
						ArrayList<Plot> next = nextPlot(u.x, u.y, bitMap);
						for(Plot v: next){
							if(!visited[v.x][v.y]){
								area++;
								visited[v.x][v.y] = true;
								allNext.add(v);
							}
						}
					}
					frontier = allNext;
				}
				if(area != 0){
					if(unBlockAreas == 0) areas.add(++area);
					else areas.add(area);
					unBlockAreas++;
				}
			}
		}
		
		int[] areaArray = new int[areas.size()];
		int i = 0;
		for(int area: areas){
			areaArray[i] = area;
			i++;
		}
		
		Arrays.sort(areaArray);
		
		
		
		return areaArray;
		
	}

	
	
	public static ArrayList<Plot> nextPlot(int x, int y, boolean[][] bitMap){
		ArrayList<Plot> next = new ArrayList<Plot>();
		if(x > 0 && bitMap[x-1][y] == false) next.add(new Plot(x-1,y));
		if(x < 599 && bitMap[x+1][y] == false) next.add(new Plot(x+1,y));
		if(y > 0 && bitMap[x][y-1] == false) next.add(new Plot(x, y-1));
		if(y < 399 && bitMap[x][y+1] == false) next.add(new Plot(x, y+1));		
		return next;	
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

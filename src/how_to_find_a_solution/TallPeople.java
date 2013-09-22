package how_to_find_a_solution;

import java.util.StringTokenizer;

public class TallPeople {
	public static void main(String[] args){
		/**
		StringTokenizer st = new StringTokenizer("3 4 3 2");
		int length = st.countTokens();
		System.out.println(length);
		String[] people = {"9 2 3",
		 "4 8 7"};

		String[] x = colToRow(people);
		for(int i = 0; i < x.length; i++){
			System.out.println(x[i]);
		}**/
		String[] people = {"1 1",
		 "1 1"}
;
		int[] x = getPeople(people);
		System.out.println(x[0] + " " + x[1]);
	}
	
	
	public static int[] getPeople(String[] people){
		int[] tall = new int[2];
		tall[0] = getShortestPerString(people[0]);
		for(String row: people){
			tall[0] = Math.max(getShortestPerString(row),tall[0]);
		}
		
		String[] peopleCol = colToRow(people);
		tall[1] = getTallestPerString(peopleCol[0]);
		for(String col: peopleCol){
			tall[1] = Math.min(getTallestPerString(col), tall[1]);
		}
		return tall;
		
	}
	
	private static int getTallestPerString(String col) {
		StringTokenizer st = new StringTokenizer(col);
		int tallest = 0;
		if(st.hasMoreTokens())
			tallest = Integer.parseInt(st.nextToken());
		while(st.hasMoreTokens()){
			int height = Integer.parseInt(st.nextToken());
			tallest = Math.max(tallest, height);
		}
		return tallest;
	}


	private static int getShortestPerString(String row) {
		StringTokenizer st = new StringTokenizer(row);
		int shortest = 0;
		if(st.hasMoreTokens())
			shortest = Integer.parseInt(st.nextToken());
		while(st.hasMoreTokens()){
			int height = Integer.parseInt(st.nextToken());
			shortest = Math.min(shortest, height);
		}
		return shortest;
	}


	public static String[] colToRow(String[] people){
		StringTokenizer st = new StringTokenizer(people[0]);
		int length = st.countTokens();	
		String[] col = new String[length];
		for(int i = 0; i < col.length; i++){
			col[i] = "";
		}
		
		for(int i = 0; i < people.length; i++){
			StringTokenizer s = new StringTokenizer(people[i]);
			int j = 0;
			while(s.hasMoreTokens()){
				col[j] += (s.nextToken() + " ");
				j++;
			}
		}
		return col;
	}

}

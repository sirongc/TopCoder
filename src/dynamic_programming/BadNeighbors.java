package dynamic_programming;

public class BadNeighbors {
	//{ 10, 3, 2, 5, 7, 8 }
	
	public static void main(String[] args){
		BadNeighbors b = new BadNeighbors();
		int[] donations = { 94, 40, 49, 65, 21, 21, 106, 80, 92, 81, 679, 4, 61,  
				  6, 237, 12, 72, 74, 29, 95, 265, 35, 47, 1, 61, 397,
				  52, 72, 37, 51, 1, 81, 45, 435, 7, 36, 57, 86, 81, 72 };
		System.out.println(b.maxDonations(donations));
	}
	public int maxDonations(int[] donations){
		int max = Math.max(maxDonations(donations, 0, true), maxDonations(donations, 1, false));
		return Math.max(max, maxDonations(donations,2,false));
	}
	
	public int maxDonations(int[] donations, int N, boolean care){//if the last element can't be added, care = true, else care = false.
		int length = donations.length;
		if(N == donations.length-1){
			if(care) return 0;
			else return donations[N];
		}		
		if(N == donations.length-2){
			if(care) return donations[length-2];
			else return Math.max(donations[length-1], donations[length-2]);
		}
		if(N == donations.length-3){
			if(care) return Math.max(donations[length-2], donations[length-3]);
			else return Math.max(donations[length-2], donations[length-3] + donations[length-1]);
		}
		return Math.max(donations[N] + maxDonations(donations, N+2, care), donations[N] + maxDonations(donations, N+3, care));
	}

}

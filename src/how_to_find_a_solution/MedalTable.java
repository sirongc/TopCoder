package how_to_find_a_solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;


public class MedalTable {
	public static void main(String[] args){
		String[] result = {"GER AUT SUI", "AUT SUI GER", "SUI GER AUT"};
		String[] r = generate(result);
		for(String s: r)
			System.out.println(s);
	}
	
	
	public static String[] generate(String[] results){
		HashMap<String, Country> map = new HashMap<String, Country>();
		StringTokenizer st = null;
		for(String c: results){
			st = new StringTokenizer(c);
			String gold = st.nextToken();
			String silver = st.nextToken();
			String bronze = st.nextToken();
			
			if(map.containsKey(gold)){
				map.get(gold).g++;
			}else{
				map.put(gold, new Country(gold,1,0,0));
			}

			if(map.containsKey(silver)){
				map.get(silver).s++;
			}else{
				map.put(silver, new Country(silver,0,1,0));
			}
			
			if(map.containsKey(bronze)){
				map.get(bronze).b++;
			}else{
				map.put(bronze, new Country(bronze,0,0,1));
			}
		}
		Country[] countries = new Country[map.size()];
		int index = 0;
		for(Country c: map.values()){
			countries[index++] = c;
		}
		Arrays.sort(countries);
		
		String[] rank = new String[countries.length];
		for(int i = 0; i < countries.length; i++){
			Country temp = countries[countries.length-1-i];
			rank[i] = temp.name + " " + temp.g + " " + temp.s + " " + temp.b;
		}
		return rank;
	}
	

}

class Country implements Comparable{
	public String name;
	public int g;
	public int s;
	public int b;
	public Country(String name, int gold, int silver, int bronze){
		this.name = name;
		g = gold;
		s = silver;
		b = bronze;
	}

	public int compareTo(Object o) {
		Country that = (Country) o;
		if(this.g > that.g) return 1;
		else if(this.g < that.g) return -1;
		
		if(this.s > that.s) return 1;
		else if(this.s < that.s) return -1;
		
		if(this.b > that.b) return 1;
		else if(this.b < that.b) return -1;
		
		if(this.name.compareTo(that.name) < 0) return 1;
		else if(this.name.compareTo(that.name) > 0) return -1;
		
		return 0;
	}
}



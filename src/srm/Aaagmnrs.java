package srm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Aaagmnrs {
	public static void main(String[] args){
		Aaagmnrs A = new Aaagmnrs();
	//	System.out.println(A.isAnagram("TopCoder", "Drop cCote"));
		
		String[] phrases = { "SnapDragon vs tomek", "savants groped monk", "Adam vents prongs ok" };
		String[] a = A.anagrams(phrases);
		for(String b: a){
			System.out.println(b);
		}
		
		//System.out.println(A.toNorm("SnapDragon vs tomek"));
		//System.out.println(A.toNorm("savants groped monk"));
		
	}
	public String[] anagrams(String[] phrases){
		HashSet<String> set = new HashSet<String>();
		set.add(toNorm(phrases[0]));
		for(int i = 1; i < phrases.length; i++){
			String normS = toNorm(phrases[i]);
			if(!set.contains(normS)) set.add(normS);
			else phrases[i] = null;
		}
		int length = 0;
		for(int i = 0; i < phrases.length; i++){
			if(phrases[i] != null) length++;
		}
		String[] newPhrases = new String[length];
		int j = 0;
		for(int i = 0; i < phrases.length; i++){
			if(phrases[i] != null) newPhrases[j++] = phrases[i];
		}
		return newPhrases;
	}
	
	
	public String toNorm(String A){
		A = A.replaceAll(" ", "");
		A = A.toLowerCase();
		char[] charA = A.toCharArray();
		Arrays.sort(charA);
		return new String(charA);
	}
	
	
	
	/**
	public String[] anagrams(String[] phrases){
		for(int i = 0; i < phrases.length; i++){
			removeAnagrams(phrases, i);
		}
		int count = 0;
		for(String s: phrases){
			if(s != null) count++;
		}
		String[] newPhrases = new String[count];
		int j = 0;
		for(int i = 0; i < phrases.length; i++){
			if(phrases[i] != null){
				newPhrases[j++] = phrases[i];
			}
		}
		return newPhrases;
		
	}
	
	public void removeAnagrams(String[] phrases, int index){
		for(int i = 0; i < index; i++){
			if(phrases[i] != null){
				if(isAnagram(phrases[i], phrases[index])) phrases[index] = null;
			}
		}
	}

	
	public boolean isAnagram(String A, String B){
		if(A == null || B == null) return false;
		A = A.toLowerCase();
		B = B.toLowerCase();
		HashMap<Character, Integer> counter = new HashMap<Character, Integer>();
		for(int i = 0; i < A.length(); i++){
			if(A.charAt(i) != ' '){
				if(counter.containsKey(A.charAt(i))) counter.put(A.charAt(i), counter.get(A.charAt(i))+1);
				else counter.put(A.charAt(i), 1);
			}
		}
		
		for(int i = 0; i < B.length(); i++){
			if(B.charAt(i) != ' '){
				if(counter.containsKey(B.charAt(i))) counter.put(B.charAt(i), counter.get(B.charAt(i))-1);
				else return false;
			}
		}
		for(Character c: counter.keySet()){
			if(counter.get(c) != 0) return false;
		}
		return true;
	}**/
}

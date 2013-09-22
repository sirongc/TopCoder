package dissect_problem;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class MatchMaking {
	public static void main(String[] args){
		String[] namesWomen = {"Constance", "Alice", "Bertha", "Delilah", "Emily"};
		String[] answersWomen = {"baabaa", "ababab", "aaabbb", "bababa", "baabba"};
		String[] namesMen = {"Ed", "Duff", "Chip", "Abe", "Biff"};
		String[] answersMen = {"aabaab", "babbab", "bbbaaa", "abbbba", "abaaba"};
		String x = makeMatch(namesWomen, answersWomen, namesMen, answersMen, "Constance");
		System.out.println(x);
		
		

		System.out.println("Doctor".substring(4));

	}
	
	public static String makeMatch(String[] namesWomen, String[] answersWomen, String[] namesMen, String[] answersMen, String queryWoman){
		Person[] women = new Person[namesWomen.length];
		Person[] men = new Person[namesMen.length];
		for(int i = 0; i < namesWomen.length; i++){
			men[i] = new Person(namesMen[i], answersMen[i]);
			women[i] = new Person(namesWomen[i],answersWomen[i]);
		}
		Arrays.sort(men);
		Arrays.sort(women);
		for(int i = 0; i < women.length; i++){
			int maxSameA = 0;
			int index = 0;
			
			for(int j = 0; j < men.length; j++){
				if(!men[j].selected && women[i].matches(men[j]) > maxSameA){
					maxSameA = women[i].matches(men[j]);
					index = j;
				}
			}
			men[index].selected = true;
			if(women[i].name.equals(queryWoman))
				return men[index].name;
		}
		return null;
	}
	
	public static class Person implements Comparable{
		String name;
		String answer;
		boolean selected;
		
		public Person(String name, String answer){
			this.name = name;
			this.answer = answer;
			selected = false;
		}
		
		public int matches(Person that){
			String a = that.answer;
			int count = 0;
			for(int i = 0; i < answer.length(); i++){
				if(answer.charAt(i) == a.charAt(i))
					count++;
			}
			return count;
		}
		
		
		public int compareTo(Object o) {
			Person that = (Person) o;
			return this.name.compareTo(that.name);
		}
		
	}

	

}

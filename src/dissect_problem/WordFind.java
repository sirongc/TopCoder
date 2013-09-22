package dissect_problem;

public class WordFind {
	
	public static void main(String[] args){
		WordFind f = new WordFind();
		String[] grid = {
				 "EASYTOFINDEAGSRVHOTCJYG",
				 "FLVENKDHCESOXXXXFAGJKEO",
				 "YHEDYNAIRQGIZECGXQLKDBI",
				 "DEIJFKABAQSIHSNDLOMYJIN",
				 "CKXINIMMNGRNSNRGIWQLWOG",
				 "VOFQDROQGCWDKOUYRAFUCDO",
				 "PFLXWTYKOITSURQJGEGSPGG"};
		String[] wordList = {"EASYTOFIND", "DIAG", "GOING", "THISISTOOLONGTOFITINTHISPUZZLE"};
		String[] A = f.findWords(grid, wordList);
		for(String a: A)
			System.out.println(a);
	}
	
	public String[] findWords(String[] grid, String[] wordList){
		String[] answers = new String[wordList.length];
		for(int i = 0; i < answers.length; i++){
			answers[i] = "";
		}
		
		for(int x = 0; x < grid[0].length(); x++){
			for(int y = 0; y < grid.length; y++){
				for(int i = 0; i < wordList.length; i++){
					String A = findWord(grid, wordList[i], y, x);
					if(A != null && answers[i].equals("")) answers[i] = A;
				}
			}
		}

		return answers;
	}
	
	public String findWord(String[] grid, String target, int y, int x){
		if(find(grid, target, y, x)) return y + " " + x;
		return null;
	}
	
	public boolean find(String[] grid, String target, int y, int x){
		if(fwRight(grid, target, y, x) || fwDown(grid, target, y, x) || fwDownRight(grid, target, y, x)) return true;
		return false;
	}
	
	public boolean fwRight(String[] grid, String target, int y, int x){
		int length = target.length();
		if(x + length > grid[0].length()) return false;
		for(int i = 0; i < length; i++){
			if(grid[y].charAt(x+i) != target.charAt(i)) return false;
		}
		return true;
	}
	
	public boolean fwDown(String[] grid, String target, int y, int x){
		int length = target.length();
		if(y + length > grid.length) return false;
		for(int i = 0; i < length; i++){
			if(grid[y+i].charAt(x) != target.charAt(i)) return false;
		}
		return true;
	}
	
	public boolean fwDownRight(String[] grid, String target, int y, int x){
		int length = target.length();
		if(y + length > grid.length || x + length > grid[0].length()) return false;
		for(int i = 0; i < length; i++){
			if(grid[y+i].charAt(x+i) != target.charAt(i)) return false;
		}
		return true;
	}

}

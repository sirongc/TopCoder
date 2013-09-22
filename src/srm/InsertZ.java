package srm;

public class InsertZ {
	public static void main(String[] args){
		String init = "opdlfmvuicjsierjowdvnx";
		String goal = "zzopzdlfmvzuicjzzsizzeijzowvznxzz";
		System.out.println(canTransform(init, goal));
		
	}
	
	public String canTransform1(String init, String goal)
    {
        // quick use of the replace String method:
        return goal.replace("z","").equals(init) ? "Yes" : "No";
    }
	
	public static String canTransform(String init, String goal){
		if(init.equals(goal)) return "Yes";
		char[] gc = goal.toCharArray();
		int temp = 0;
		for(int i = 0; i < gc.length; i++){
			if(gc[i] == 'z'){
				gc[i] = ' ';
				temp++;
			}
		}
		
		char[] newGC = new char[gc.length-temp];
		int i = 0;
		for(char c: gc){
			if(c != ' ') newGC[i++] = c;
		}
		if(init.equals(new String(newGC))) return "Yes";
		return "No";
	}
	
	

}

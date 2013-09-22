package dissect_problem;

public class UserName {
	public static void main(String[] args){
		String[] s = 	{"grokster2", "BrownEyedBoy", "Yoop", "BlueEyedGirl", "grokster", "Elemental", "NightShade", "Grokster1"};
		System.out.println(newMember(s, "grokster"));
		
	}
	
	public static String newMember(String[] existingNames, String newName){
		int i = 1;
		String name = newName;
		while(consists(existingNames, name)){
			name = newName + i;
			i++;
		}
		return name;
	}
	

	public static boolean consists(String[] existingNames, String newName){
		for(String s : existingNames){
			if(s.equals(newName))
				return true;
		}
		return false;
	}

}

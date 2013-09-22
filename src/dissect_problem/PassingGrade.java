package dissect_problem;

public class PassingGrade {
	public static void main(String[] args){
		int[] pointsEarned = {600,600,600,600,600,600,600,600,600,600,
				 600,600,600,600,600,600,600,600,600,600};
		int[] pointsPossible = {1000,1000,1000,1000,1000,1000,1000,1000,
				 1000,1000,1000,1000,1000,1000,1000,1000,
				 1000,1000,1000,901};
		int finalExam = 3000;
		System.out.println(pointsNeeded(pointsEarned, pointsPossible, finalExam));
	}
	
	public static int pointsNeeded(int[] pointsEarned, int[] pointsPossible, int finalExam){
		double sumPointsEarned = 0;
		for(int i: pointsEarned)
			sumPointsEarned +=i;
		
		double sumPointsPossible = 0;
		for(int i:pointsPossible)
			sumPointsPossible +=i;
		sumPointsPossible += finalExam;

		for(int i = 0; i <= finalExam; i++){
			if((sumPointsEarned+i)/sumPointsPossible >= 0.65)
				return i;
		}
		return -1;
	}
}

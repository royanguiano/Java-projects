import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int bears;
		boolean answer;
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter number of bears: ");
		bears = input.nextInt();
		answer = beatCount(bears);
		
		System.out.println("Bears(" + bears + ") is " + answer);
	}

	public static boolean beatCount(int bears) {
		// need a base caes: check if bears == 42
		// there are 2 base case: check if less is 42
		// professor does not care about efficiency

		// base case: checking if I have 42 bears left
		if (bears == 42) {
			return true;
		} 
		if (bears < 42) {
			return false;
		}
		if(bears % 5 ==0){
			if(beatCount(bears - 42))
				return true; 
		}
		if (bears % 2 == 0){
			if(beatCount(bears/2)){
				return true; 
			}
		}
		if(((bears % 3 == 0 || bears % 4 == 0) && ((bears%100)/10) * (bears %10) != 0)){
			if(beatCount(bears -((bears % 10) * ((bears % 100)/ 10)))){
				return true; 
			}
		}
		return false; 
	}
}

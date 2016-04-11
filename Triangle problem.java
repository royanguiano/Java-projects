import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		
		System.out.println("First: ");
		int m = input.nextInt();
		System.out.println("Second: ");
		int n = input.nextInt();

		triangle(m, n);
	}
	
	public static void triangle(int m, int n){
		//base case
		if(m > n){
			return;
		} else if(m <= n){						//precondition
			for(int i = 0; i < m; i++){
				System.out.print("*");
			}
			System.out.println();
			triangle(m + 1, n);
			for (int i = 0	; i < m; i++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}

}

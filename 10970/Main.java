// salazara
// PROBLEM 10970 - BIG CHOCOLATE

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		while(scan.hasNextInt()){
			
			int m = scan.nextInt();
			int n = scan.nextInt();
			int result = m * n - 1;
			
			System.out.println(result);
			
		}
		

		
	}
	
}

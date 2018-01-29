// salazara
// PROBLEM 113: Power of Cryptography

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()){
		
			double n = sc.nextDouble();
			double p = sc.nextDouble();
			
			System.out.println(Math.round(Math.pow(p, 1/n)));
			
		}	

	}

}

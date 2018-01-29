// salazara
// PROBLEM 100 - THE 3n + 1 PROBLEM

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()){
	
			int i = sc.nextInt();
			int j = sc.nextInt();
			
			int lo = Math.min(i,  j);
			int hi = Math.max(i,  j);
			int M = 0;
		
			for(int c = lo; c <= hi ; c++){
				
				M = Math.max(M, cycle_length(c));
			}
			
			System.out.println(i + " " + j + " " + M);
			
		}

	}
	
	static int cycle_length(int n){
		
		int c = 1; 
		
		while(n > 1){
			
			
			if(n % 2 == 0){
				
				n /= 2;
				
			}
			
			else{
				
				n *= 3;
				n++;
			
			}
			
			c++;
		}
		
		return c;
		
	}
	
}
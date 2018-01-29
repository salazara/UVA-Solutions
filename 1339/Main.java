// salazara
// PROBLEM 1339 - ANCIENT CIPHER

import java.util.Arrays;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		while(scan.hasNext()){
		
			int[] a1 = new int[26];
			int[] a2 = new int[26];  
			
			String msg1 = scan.next();
			String msg2 = scan.next();
			
			for(int i = 0 ; i < msg1.length() ; i++){
				a1[msg1.charAt(i) - 'A']++;
				a2[msg2.charAt(i) - 'A']++;
			}
			
			Arrays.sort(a1);
			Arrays.sort(a2);

			if(Arrays.equals(a1, a2)){
				System.out.println("YES");
			}
			
			else{
				System.out.println("NO");
			}
						
		}

	}

}

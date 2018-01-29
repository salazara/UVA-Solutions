import java.util.Scanner;

// salazara
// PROBLEM 10252

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		char [] letters = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		
		while(sc.hasNext()){
			
			String a = sc.nextLine();
			String b = sc.nextLine();
			
			int[] ma = new int[letters.length];
			int[] mb = new int[letters.length]; 
			
			for(int i = 0 ; i < letters.length ; i++)
				for(int j = 0 ; j < a.length(); j++)
					if(a.charAt(j) == letters[i])
						ma[i]++;
			
			for(int i = 0 ; i < letters.length ; i++)
				for(int j = 0 ; j < b.length(); j++)
					if(b.charAt(j) == letters[i])
						mb[i]++;
			
			String x = "";
			for(int i = 0 ; i < letters.length ; i++)
				for(int j = 0 ; j < Math.min(ma[i], mb[i]) ; j++)
					x += letters[i];
			
			System.out.println(x);
			
		}

	}

}

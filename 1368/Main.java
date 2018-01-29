// salazara
// PROBLEM 1368 - DNA Consensus String

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int T = scan.nextInt();
		
		for(int k = 0 ; k < T ; k++){
			
			int m = scan.nextInt();
			int n = scan.nextInt();
			
			String dna[] = new String[m];
			
			for(int i = 0 ; i < m ; i++){
				
				dna[i] = scan.next();
			
			}
			
			String consensus = new String();
			
			for(int i = 0 ; i < n ; i++){
				
				int[] count = new int[4];
				
				for(int j = 0 ; j < m ; j++){
					
					switch(dna[j].charAt(i)){
					
						case 'A':
							count[0]++;
							break;
						case 'C':
							count[1]++;
							break;
						case 'G':
							count[2]++;
							break;
						case 'T':
							count[3]++;
							break;		
							
					}
					
				}
				
				int tmp[] = new int[4];
				
				System.arraycopy(count, 0, tmp, 0, tmp.length);
				Arrays.sort(tmp);
				
				int most = tmp[3];
				
				if(count[0] == most){
					consensus += 'A';
				}
				else if(count[1] == most){
					consensus += 'C';
				}
				else if(count[2] == most){
					consensus += 'G';
				}
				else{
					consensus += 'T';
				}
				
			}
			
			System.out.println(consensus);
			
			int error = 0;
			
			for(int i = 0 ; i < n ; i++){
				
				for(int j = 0 ; j < m ; j++){
					
					if(consensus.charAt(i) != dna[j].charAt(i)){
						error++;
					}
					
				}
				
			}
			
			System.out.println(error);
						
		}

	}
	
}


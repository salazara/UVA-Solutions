// salazara
// PROBLEM 102 - Ecological Bin Packing 

import java.util.Scanner;

public class Main {

	static int[] B = new int[9];
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		
		while(sc.hasNext()){
		
			
			for(int i = 0 ; i < 9 ; i++){
				B[i] = sc.nextInt();
			}
			
			String [] bin_combos = {"BCG", "BGC", "CBG", "CGB", "GBC", "GCB"};
			
			int[] Moves = new int[6];
			
			// index:
			// 0 3 6 is brown
			// 1 4 7 is green
			// 2 5 8 is clear
			
			Moves[0] = get_moves(0, 5, 7); // BCG
			Moves[1] = get_moves(0, 4, 8); // BGC
			Moves[2] = get_moves(2, 3, 7); // CBG
			Moves[3] = get_moves(2, 4, 6); // CGB
			Moves[4] = get_moves(1, 3, 8); // GBC
			Moves[5] = get_moves(1, 5, 6); // GCB
			
			int min = (int) Math.pow(2, 31);
			
			String bin_choice = "";
			
			for(int i = 0; i < 6 ; i++){
			
				if(min > Moves[i]){
					
					min = Moves[i];
					bin_choice = bin_combos[i];
					
				}
				
			}
			
			System.out.println(bin_choice + " " + min);
		}	
		


	}
	
	public static int get_moves(int a, int b, int c){
		
		int moves = 0;
		
		for(int i = 0 ; i < 9 ; i++){
			if(i != a && i != b && i != c){
				
				moves += B[i];
				
			}
		}
		
		return moves;
	
	}


	
}

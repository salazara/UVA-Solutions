// salazara
// PROBLEM 10038 : JOLLY JUMPERS

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()){
		
			String s = sc.nextLine();
			String[] t = s.split("\\s");
			
			int[] n = new int[t.length];
						
			for(int i = 0 ; i < t.length ; i++){
				
				n[i] = Integer.parseInt(t[i]);
			
			}
			
			List<Integer> diff = new ArrayList<Integer>();
			
			for(int i = 0 ; i < t.length - 2 ; i++){
			
				diff.add(Math.abs(n[i + 1] - n[i + 2]));
			
			}
			
			Collections.sort(diff);
			
			System.out.println(isJolly(diff, n[0] - 1) ? "Jolly" : "Not jolly");
		
		}
	}
	
	static boolean isJolly(List<Integer> diff, int size){
		
		if(diff.size() != size){
			
			return false;
			
		}
		
		for(int i = 0 ; i < size  ; i++){

			if(diff.get(i) != i + 1 ){
				
				return false;
			
			}
		
		}
		
		return true;
	}
}



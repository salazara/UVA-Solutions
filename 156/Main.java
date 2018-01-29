import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

// salazara
// PROBLEM 156 : ANANAGRAMS


public class Main {

	public static String get_key(String s){

		s = s.toLowerCase();
		
		char [] a  = s.toCharArray();
		Arrays.sort(a);
		
		return new String(a);
		
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		HashMap<String, ArrayList<String>> hmap = new HashMap<String, ArrayList<String>>();
		
		String temp = "";
		
		while(true){
			
			temp = sc.next();
			
			if(temp.equals("#")){
				
				break;
				
			}
			
			else{
				
				String key = get_key(temp);
				if(!hmap.containsKey(key)){
					hmap.put(get_key(temp), new ArrayList<String>());
					hmap.get(key).add(temp);
				}
				else{
					hmap.get(key).add(temp);
				}
			}
			
		}
				
		ArrayList <String> result = new ArrayList<String>();
		for(String key : hmap.keySet()){
			if(hmap.get(key).size() != 1){
				continue;
			}
			else{
				result.add(hmap.get(key).get(0));
			}
		}
		
		Collections.sort(result);
		
		for(int i = 0 ; i < result.size() ; i++){
			System.out.println(result.get(i));
		}
		
	}

}

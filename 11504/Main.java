import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

// salazara
// PROBLEM 11504

public class Main {

	static HashMap<Integer, ArrayList<Integer>> G;
	static HashMap<Integer, Boolean> visited;
	static ArrayList<Integer> topoList;
	
	static int T;
	static int n;
	static int m;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		T = sc.nextInt();
		
		for(int t = 1 ; t <= T ; t++){
		
			G = new HashMap<Integer, ArrayList<Integer>>();
			
			n = sc.nextInt();
			m = sc.nextInt();
			
			for(int i = 1 ; i <= n ; i++)
				G.put(i, new ArrayList<Integer>());
			
			for(int i = 1 ; i <= m ; i++){
				
				int x = sc.nextInt();
				int y = sc.nextInt();
				
				G.get(x).add(y);
			
			}
			
			topoSort();
			
			printCount();
				
		}

	}
	
	static void topoSort() {
			
		 visited = new HashMap<Integer, Boolean>();
		 
		 for(int i = 1 ; i <= n ; i++)
			visited.put(i, false);
		 
		 topoList = new ArrayList<Integer>();
		 
		 for(Integer i : G.keySet())
			 if (!visited.get(i))
				 topoDFS(i);

		 Collections.reverse(topoList);
		 
	}
	
	static void topoDFS(int curr){
		
		visited.put(curr, true);
	
		for(Integer i : G.get(curr))
			if(!visited.get(i))
				topoDFS(i);	
	
		topoList.add(curr);
		
	}
	
	static void printCount(){
		
		visited =  new HashMap<Integer, Boolean>();
		
		for(int i = 1 ; i <= n ; i++)
			visited.put(i, false);
		
		int c = 0;
		
		for(Integer i : topoList)
			if(!visited.get(i)){
				c++;
				countDFS(i);
			}
			
		System.out.println(c);
		
	}
	
	static void countDFS(int curr){
		
		visited.put(curr, true);
	
		for(Integer i : G.get(curr))
			if(!visited.get(i))
				countDFS(i);
		
	}
	
}

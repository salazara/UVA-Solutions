/*

1
4 3
Smith, M.N., Martin, G., Erdos, P.: Newtonian forms of prime factor matrices
Erdos, P., Reisig, W.: Stuttering in petri nets
Smith, M.N., Chen, X.: First oder derivates in structured programming
Jablonski, T., Hsueh, Z.: Selfstabilizing data structures
Smith, M.N.
Hsueh, Z.
Chen, X.


 */

// salazara
// UVA PROBLEM : 10044

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Node{
	
	String name;
	Set<Node> friends;

	int dist;
	boolean vis;
	
	public Node(String name){
		
		this.name = name;
		friends = new HashSet<Node>();
		
		dist = 0;
		vis = false;
		
	}
	
	 @Override
	 public int hashCode(){
		 return name.hashCode();
	 }
	   
	 @Override
	 public boolean equals(Object o){
		 if (this == o)
			 return true;
		
		 if (!(o instanceof Node))
			 return false;
	    
		 Node node = (Node) o;
		 return this.name.equals(node.name);
	 }
	
}

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.valueOf(in.readLine());
		
		for(int i = 1 ; i <= T ; i++){
			
			String[] PN;
			
			PN = in.readLine().split(" ");
			
			int P = Integer.parseInt(PN[0]);
			int N = Integer.parseInt(PN[1]);
		
			HashMap<String, Node> G = new HashMap<String, Node>();
			
			for(int j = 0 ; j < P ; j++){
				
				String paper = in.readLine();
				String[] names = paper.split(":")[0].split(",");
			
				ArrayList<String> list_names = new ArrayList<String>();
				
				for(int k = 0 ; k < names.length ; k += 2){
					if(k + 1 >= names.length)
						list_names.add(names[k].trim());
					else
						list_names.add(names[k].trim() + ", "  + names[k + 1].trim());
				}
				
				for(int k1 = 0 ; k1 < list_names.size() ; k1++){
					
					if(!G.containsKey(list_names.get(k1)))
						G.put(list_names.get(k1), new Node(list_names.get(k1)));
					
					for(int k2 = 0 ; k2 < list_names.size() ; k2++){
					
						if(k1 == k2)
							continue;
						
						G.get(list_names.get(k1)).friends.add(new Node(list_names.get(k2)));  
						
						if(!G.containsKey(list_names.get(k2)))	
							G.put(list_names.get(k2), new Node(list_names.get(k2)));
						
						G.get(list_names.get(k2)).friends.add(new Node(list_names.get(k1)));
					
					}
				}
				
			}
			
			// print graph
			
			/*
			for(String s : G.keySet()){
				System.out.print(s + " :");
				for(Node n : G.get(s).friends){
					System.out.print(" " + n.name);
				}
				System.out.println();
			}
			*/
			
			System.out.println("Scenario " + i);
			
			erdosRelations("Erdos, P.", G);
			
			for(int j = 0; j < N; j++) {
				
				String name = in.readLine();
				System.out.print(name + " ");
				
				if(!G.containsKey(name)){
					System.out.println("infinity");
					continue;
				}
				
				if(G.get(name).dist > 0)
					System.out.println(G.get(name).dist);
				else
					System.out.println("infinity");
				
			}
			
		}
		
		
	}

	// perform breadth first search starting from String a
	public static void erdosRelations(String erdos, HashMap<String, Node> G){
		
		Queue<Node> q = new LinkedList<Node>();
	
		q.add(G.get(erdos));
		
		while(!q.isEmpty()){
			
			Node curr = q.peek();
			q.poll();
			
			for(Node n : curr.friends){
				
				if(G.get(n.name).vis == false){
					
					G.get(n.name).vis = true;
					G.get(n.name).dist = G.get(curr.name).dist + 1;					
					q.offer(G.get(n.name));
					
				}
							
			}
			
		}
		
				
	}

}
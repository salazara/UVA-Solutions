import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

// salazara
// PROBLEM 196

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 1; t <= T ; t++){
			
			HashMap<String, ArrayList<String>> graph = new HashMap<String, ArrayList<String>>();
			
			int col = sc.nextInt();
			int row = sc.nextInt();
			
			String[][] sheet = new String[row][col];
			
			for(int r = 0 ; r < row ; r++)
				for(int c = 0 ; c < col ; c++){
					
					sheet[r][c] = sc.next();
					
					graph.put(getPosition(r, c), new ArrayList<String>());
					
					if(sheet[r][c].contains("=")){
						
						String [] deps = sheet[r][c].replace("=", "").split("\\+");
						
						for(String s : deps)
							graph.get(getPosition(r, c)).add(s);
					}
						
				}
			
			/*
			for(String key : graph.keySet()){
				System.out.print(key + " :");
				for(String i : graph.get(key)){
					System.out.print(" " + i);
				}
				System.out.println();
			}
			*/
			
			ArrayList<String> sorted = dfs_topologicalSort(graph);
			
			for(String s : sorted){
				
				if(graph.get(s).size() == 0)
					continue;
				
				int sum = 0; 
				
				for(String i : graph.get(s)){
					String[] rc = getIndex(i).split(" ");
					sum += Integer.parseInt(sheet[Integer.parseInt(rc[0])][Integer.parseInt(rc[1])]);
				}
				
				String[] rc = getIndex(s).split(" ");
				sheet[Integer.parseInt(rc[0])][Integer.parseInt(rc[1])] = "";
				sheet[Integer.parseInt(rc[0])][Integer.parseInt(rc[1])] += sum;
			}
			
			for(int r = 0 ; r < row ; r++){
				for(int c = 0 ; c < col ; c++){
					if(c < col - 1)
						System.out.print(sheet[r][c] + " ");
					else
						System.out.print(sheet[r][c]);
				}
				System.out.println();
			}
			
		}
		
	}
	
	static String getIndex(String s){
		
		String letters = s.replaceAll("[^A-Z ]", "");
		String numbers = s.replaceAll("[^0-9 ]", "");
		
		int c = -1;
		
		for(int i = 0 ; i < letters.length() ; i++)
			c += ((int) letters.charAt(i) - 64) * (Math.pow(26, letters.length() - (i + 1)));
			
		int r = Integer.parseInt(numbers) - 1;

		return r + " " + c;
	}
	
	static String getPosition(int r, int c){
        
		int remainder;
		int quotient = c;
		
        String result = "";

        while (quotient >= 0)
        {
            remainder = quotient % 26;
            result = (char)(remainder + 65) + result;
            quotient = (int)Math.floor(quotient/26) - 1;
        }

        result += (r + 1);
        
		return result;
	}

	 static void dfs_visit(HashMap<String, ArrayList<String>> graph, HashMap<String, Boolean> used, List<String> res, String u) {
		 	
		 	used.put(u, true);
		    
		 	for (String v : graph.get(u))
		    	if (!used.get(v))
		    	  dfs_visit(graph, used, res, v);
		    
		    res.add(u);
	 }

	 public static ArrayList<String> dfs_topologicalSort(HashMap<String, ArrayList<String>> graph) {
		
		 HashMap<String, Boolean> used = new HashMap<String, Boolean>();

		 for(String s : graph.keySet())
			 used.put(s, false);

		 ArrayList<String> res = new ArrayList<String>();
		 
		 for(String s : graph.keySet())
			 if (!used.get(s))
				 dfs_visit(graph, used, res, s);
		 
		 return res;
	}
}

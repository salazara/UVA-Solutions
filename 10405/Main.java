import java.util.Scanner;

// salazara
// PROBLEM 10405

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNextLine()){
			String a = sc.nextLine();
			String b = sc.nextLine();
			System.out.println(lcs(a, b).length());
		}

	}

	// algorithm via rosetta code: lcs using dp
	public static String lcs(String a, String b) {
		
	    int[][] lengths = new int[a.length() + 1][b.length() + 1];
	 
	    for (int i = 0 ; i < a.length() ; i++)
	        for (int j = 0 ; j < b.length() ; j++)
	            if (a.charAt(i) == b.charAt(j))
	                lengths[i + 1][j + 1] = lengths[i][j] + 1;
	            else
	                lengths[i + 1][j + 1] = Math.max(lengths[i + 1][j], lengths[i][j + 1]);
	 
	    StringBuffer sb = new StringBuffer();
        
	    for (int x = a.length(), y = b.length() ; x != 0 && y != 0 ; ) {
	        if (lengths[x][y] == lengths[x - 1][y])
	            x--;
	        else if (lengths[x][y] == lengths[x][y - 1])
	            y--;
	        else {
	            assert a.charAt(x - 1) == b.charAt(y - 1);
	            sb.append(a.charAt(x - 1));
	            x--;
	            y--;
	        }
	    }
	 
	    return sb.reverse().toString();
	}
	
}

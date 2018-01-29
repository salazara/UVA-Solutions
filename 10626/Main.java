import java.util.Scanner;

// salazara
// PROBLEM 10626

public class Main {

	static int c;
	static int [][][] dp;
	static int total;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 0 ; t < T ; t++){
			
			c = sc.nextInt();
			int n1 = sc.nextInt();
			int n5 = sc.nextInt();
			int n10 = sc.nextInt();
			
			dp = new int[200][200][200];
			total = n1 + n5*5 + n10*10;
			
			System.out.println(f(c, n5, n10));
			
		}
		
	}
	
	static int f(int i, int n5, int n10){
		
		if(dp[i][n5][n10] != 0)
			return dp[i][n5][n10];
        
		if(i <= 0){
			dp[i][n5][n10] = 0;
			return 0;
		}
		
		int result = Integer.MAX_VALUE;
		int n1 = total - (c-i)*8 - n5*5 - n10*10;
		
		if(n1 >= 8)
			result = Math.min(result, 8 + f(i - 1, n5, n10));
		if (n5 >= 1 && n1 >= 3)
			result = Math.min(result, 4 + f(i - 1, n5 - 1, n10));
		if (n10 >= 1 && n1 >= 3)
			result = Math.min(result, 4 + f(i - 1, n5 + 1, n10 - 1));
		if (n5 >= 2)
			result = Math.min(result, 2 + f(i - 1, n5 - 2, n10));
		if (n10 >= 1)
			result = Math.min(result, 1 + f(i - 1, n5, n10 - 1));

		dp[i][n5][n10] = result;
        
		return result;
	}

}

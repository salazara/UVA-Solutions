import java.util.Scanner;

// salazara
// PROBLEM 147

public class Main {
	
	public static void main(String args[]){
		
		Scanner sc = new Scanner(System.in);
		
		int [] coins = {5, 10, 20, 50, 100, 200, 500, 1000, 2000, 5000, 10000};
		long [] dp = new long[30001];
		
		dp[0] = 1;
		for(int i = 0 ; i < coins.length ; i++)
			for(int j = coins[i]  ; j < dp.length ; j++)
					dp[j] += dp[j - coins[i]];
		
	    double in;
	  
	    while((in = sc.nextDouble()) != 0)
	        System.out.printf("%6.2f%17d\n", in, dp[(int) Math.round(in * 100)]);
	
	}
	
}

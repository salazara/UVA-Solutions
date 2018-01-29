import java.util.ArrayList;
import java.util.Scanner;

// salzara
// PROBLEM 11137

public class Main {

	public static void main(String[] args) {
	
		ArrayList<Integer> cubes = new ArrayList<Integer>();
		for(int i = 0 ; (i+1)*(i+1)*(i+1) <= 9261; i++)
			cubes.add((i+1)*(i+1)*(i+1));
		
		long [] dp = new long[10001];
		
		dp[0] = 1;
		for(int i = 0 ; i < cubes.size() ; i++)
			for(int j = cubes.get(i)  ; j < dp.length ; j++)
					dp[j] += dp[j - cubes.get(i)];
		
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()){
			System.out.println(dp[sc.nextInt()]);
		}
	}

}

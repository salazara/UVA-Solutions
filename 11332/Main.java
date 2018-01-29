import java.util.Scanner;


// salazara
// PROBLEM 11332

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		while(true){
			long n = sc.nextLong();
			if(n == 0)
				break;
			System.out.println(f(n+""));
		}
		
	}
	
	static long f(String n){
		
		long sum = 0;
		for(int i = 0 ; i < n.length() ; i++)
			sum += Long.parseLong(n.charAt(i)+"");
		if(sum < 10)
			return sum;
		else
			return f(sum+"");
		
	}
	
}

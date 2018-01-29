import java.util.Scanner;

// salazara
// PROBLEM 10387

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		while(true){
			
			double a = sc.nextDouble();
			double b = sc.nextDouble();
			double s = sc.nextDouble();
			double m = sc.nextDouble();
			double n = sc.nextDouble();
			
			if((a==0)&&(b==0)&&(s==0)&&(m==0)&(n==0))
				break;
			
			double angle = Math.toDegrees(Math.atan((b*n)/(a*m)));
			double velocity = Math.sqrt((a*m)*(a*m)+(b*n)*(b*n))/s;
			
			System.out.printf("%.2f %.2f\n" , angle, velocity);
			
		}
		
	}

}

import java.util.Scanner;

// salazara
// PROBLEM 10050

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		while(T > 0){
			
			int N = sc.nextInt();
			int P = sc.nextInt();
			int[] H = new int[P];
			
			for(int i = 0 ; i < P ; i++){
			
				H[i] = sc.nextInt();
				
			}
				
			int loss = 0;
			
			for(int day = 1 ; day <= N ; day++){
				
				if((day % 7) == 6 || (day % 7 == 0)){
					continue;
				}
				
				for(int i = 0 ; i < P ; i++){
					
					if((day % H[i]) == 0){
						loss++;
						break;
					}
					
				}
				
			}
			
			System.out.println(loss);
			T--;
		
		}
	}	
}

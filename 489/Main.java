import java.util.Scanner;

// salazara
// PROBLEM 489

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int r = sc.nextInt();
		
		while(r != -1){
			
			String word = sc.next();
			String guess = sc.next();
			
			int strokes = 0;
			
			for(int i = 0 ; i < guess.length() && !word.equals("") ; i++){
				
				if(word.contains(""+guess.charAt(i)))
					word = word.replaceAll(""+guess.charAt(i), "");

				else
					strokes++;
				
			}
			
			System.out.println("Round " + r);
			
			if(strokes < 7){
				if(word.equals(""))
					System.out.println("You win.");
				else
					System.out.println("You chickened out.");
			}
			else
				System.out.println("You lose.");
			
			r = sc.nextInt();
		}
		
	}

}

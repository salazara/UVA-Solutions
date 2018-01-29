import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

// salazara
// PROBLEM 10788 : Parenthesizing Palindromes

public class Main {
	
	public static void main(String[]args){
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 1 ; t <= T ; t++){
			
			String s = sc.next();
			
			Deque<Character> stack = new ArrayDeque<Character>();
		
			for(int i = 0 ; i < s.length() ; i++){
			
				if(stack.isEmpty() || stack.peek() != s.charAt(i))
					stack.push(s.charAt(i));
			
				else
					stack.pop();
				
			}
			
			check(stack, s, t);
		}
	}
	
	static void check(Deque<Character> stack, String s, int t){
		
		if(stack.isEmpty()){
			
			int c = 0;

			for (int i = 0; i < s.length() - 1; i++){
				
				if (s.charAt(i) == s.charAt(i+1))
					c++;
				
				else
					c = 0;

				if (c > 1){
					
					System.out.println ("Case " + t + ": Valid, Multiple");
					return;
				
				}
				
			}

			for (int i = 0; i < s.length() - 1; i++){
			
				if(s.charAt(i) == s.charAt(i + 1)){
				
					String temp = s.substring(i, i + 2);
			
					if (s.replaceFirst(temp, "").contains(temp)){
					
						System.out.println ("Case " + t + ": Valid, Multiple");
						return;
				
					}
				}

			}
		
			System.out.println ("Case " + t + ": Valid, Unique");
			return;
		}
	
		else{
			System.out.println ("Case " + t + ": Invalid");
			return;
		}
		
	}
}
	


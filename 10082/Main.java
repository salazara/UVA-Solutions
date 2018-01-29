import java.util.Scanner;

// salazara
// PROBLEM 10082

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String kb_string = "`1234567890-=QWERTYUIOP[]" + "\\" + "ASDFGHJKL;'ZXCVBNM,./";
		char[] kb = kb_string.toCharArray();
		
		while(sc.hasNext()){
			
			String s = sc.nextLine();
			char[] c = s.toCharArray();
			
			for(int i = 0 ; i < c.length ; i++){
				
				if(c[i] == ' '){
					
					continue;
				
				}
				
				for(int j = 0 ; j < kb.length ; j++){
				
					if(c[i] == kb[j]){
					
						c[i] = kb[j-1];
					
					}
			
				}
			
			}
			
			System.out.println(new String(c));
		}

	}

}

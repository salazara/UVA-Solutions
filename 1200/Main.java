import java.util.Arrays;
import java.util.Scanner;

// salazara
// PROBLEM 1200

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		for(int t = 0 ; t < T ; t++){
			
			String s = sc.next();
			
			String[] exp = s.split("=");
			
			String exp1 = exp[0].replaceAll("-", "\\+-");
			String exp2 = exp[1].replaceAll("-", "\\+-");
			
			String[] terms1 = exp1.split("\\+");
			String[] terms2 = exp2.split("\\+");
		
			if(terms1[0].equals(""))
				terms1 = Arrays.copyOfRange(terms1, 1, terms1.length);
			if(terms2[0].equals(""))
				terms2 = Arrays.copyOfRange(terms2, 1, terms2.length);
			
			double xt1 = 0;
			double ct1 = 0;	
			
			for(String term : terms1){
				
				String temp = term.replaceAll("x", "");
				
				if(term.contains("x")){
					
					if(temp.equals("") || temp.equals("-"))
						temp += "1";
					
					xt1 += Integer.parseInt(temp);
					
				}
				else
					ct1 += Integer.parseInt(temp);
			}
			
			double xt2 = 0;
			double ct2 = 0;	
			
			for(String term : terms2){
				
				String temp = term.replaceAll("x", "");
				
				if(term.contains("x")){
					
					if(temp.equals("") || temp.equals("-"))
						temp += "1";
					
					xt2 += Integer.parseInt(temp);
					
				}
				else				
					ct2 += Integer.parseInt(temp);
			}
			
			if(xt1 - xt2 == 0 && ct1 - ct2 == 0)
				System.out.println("IDENTITY");
			else if(xt1 - xt2 == 0)
				System.out.println("IMPOSSIBLE");
			else
				System.out.println((int) Math.floor( (ct2 - ct1) / (xt1 - xt2) ));
			
		}
		
	}

}

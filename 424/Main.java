import java.math.BigInteger;
import java.util.Scanner;

// salazara
// PROBLEM 424

public class Main {
	
    public static void main(String args[]) {
    
    	Scanner sc = new Scanner(System.in);
        BigInteger sum = BigInteger.valueOf(0);
        
        while(true) {
        	
            BigInteger n = sc.nextBigInteger();
         
            if(n.equals(BigInteger.valueOf(0))){
            
            	break;
            
            }
            
            sum = sum.add(n);
        
        }
        
        System.out.println(sum);
    
    }

}

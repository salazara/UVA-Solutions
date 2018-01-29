import java.util.Scanner;

// salazara
// PROBLEM 10191

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in).useDelimiter("\\s*\n\\s*");
		
		int days = 0;
		while(sc.hasNext()){
			
			days++;
			
			int D = sc.nextInt();
			int[]t1 = new int[D];
			int[]t2 = new int[D];
			
			for(int d = 0 ; d < D ; d++){
				
				String s = sc.next();
				String[] ss = s.split(" ");
				
				t1[d] = 60 *Integer.parseInt(ss[0].split(":")[0]) + Integer.parseInt(ss[0].split(":")[1]) ;
				t2[d] = 60 *Integer.parseInt(ss[1].split(":")[0]) + Integer.parseInt(ss[1].split(":")[1]) ;
				
			}
			
			bubbleSort(t1, t2);
			
			int max = -1;
			String start = new String();
			
			if(max < t1[0] - 10*60){
				max = t1[0] - 10*60;
				start = "";
				start += "10:00";
			}	
			
			for(int i = 0 ; i < D - 1 ; i++){
				if(max < t1[i + 1] - t2[i]){
					max = t1[i + 1] - t2[i];
					start = "";
					start += t2[i]/60 < 10 ? "0" + t2[i]/60 : t2[i]/60;
					start += ":";
					start += t2[i]%60 < 10 ? "0" + t2[i]%60 : t2[i]%60;
				}
			}
			
			if(max < 18*60 - t2[D-1]){
				max = 18*60 - t2[D-1];
				start = "";
				start += t2[D-1]/60 < 10 ? "0" + t2[D-1]/60 : t2[D-1]/60;
				start += ":";
				start += t2[D-1]%60 < 10 ? "0" + t2[D-1]%60 : t2[D-1]%60;
			}
			
			System.out.print("Day #" + days + ": ");
			System.out.print("the longest nap starts at ");
			System.out.print(start + " ");
			System.out.print("and will last for ");
			System.out.println(max < 60 ? max % 60 + " minutes." : max / 60 + " hours and " + max % 60 + " minutes.");
				
		}
		
		
	}
	
	   static void bubbleSort(int[] t1, int[] t2) {
          
           int temp = -1;
          
           for(int i=0; i < t1.length ; i++){
                   for(int j = 1; j < t1.length -i ; j++){
                          
                           if(t1[j-1] > t1[j]){
                                  
                                   temp = t1[j-1];
                                   t1[j-1] = t1[j];
                                   t1[j] = temp;
                           
                                   temp = t2[j-1];
                                   t2[j-1] = t2[j];
                                   t2[j] = temp;
                                   
                           }
                           else if(t1[j-1] == t1[j]){
                               

                        	   if(t2[j - 1] > t2[j]){
                        		   temp = t2[j-1];
                        		   t2[j-1] = t2[j];
                        		   t2[j] = temp;
                               }
                               
                           }
                          
                   }
           }
  
   }

}

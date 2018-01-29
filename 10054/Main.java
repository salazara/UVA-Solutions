import java.util.Scanner;

/*
2
5
1 2
2 3
3 4
4 5
5 6
5
2 1
2 2
3 4
3 1
2 4
 */

// salazara
// PROBLEM 10054

class Main{
	
	static void euler(int m, int map[][]) {
		
        int i;
		
        for (i = 1 ; i <= 50 ; i++)
			if (map[m][i]>0) {
				map[m][i]--;
				map[i][m]--;  
				euler(i, map);  
				System.out.println(i + " " + m);  
            }
        
	}  
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();

		for (int t = 1 ; t <= T; t++) {  

			int x = 0;
			int y = 0;
			
			int n = sc.nextInt();  
			
			int [][] map = new int [60][60];
			
			for (int i = 1 ; i<=n ; i++) {
				
				x = sc.nextInt();
				y = sc.nextInt();
				  
				map[x][0]++;
				map[y][0]++;  
				map[x][y]++;
				map[y][x]++;
                
			}  
			
            int flag = 0;
            
			for (int i = 1; i <= 50; i++) {
            
                flag = map[i][0] % 2;
                
                if (flag != 0)
					break;  
			
            }
			
			System.out.println("Case #" + t);  
			
			if (flag != 0)
				System.out.println("some beads may be lost");  
			
            else
				euler(x, map);  

			if(t < T)
				System.out.println();
			
		}   
	} 
}


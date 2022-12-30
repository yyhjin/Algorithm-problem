import java.util.Scanner;

public class Main_2563_색종이 {

	public static void main(String[] args) {
		
		Scanner scann = new Scanner(System.in);
		int N = scann.nextInt();
		int map[][] = new int[100][100];
		int maxX=Integer.MIN_VALUE;
		int maxY = Integer.MIN_VALUE;
		
		for (int t = 0; t < N; t++) {
			int x = scann.nextInt();
			int y = scann.nextInt();
			
			maxX= Math.max(maxX, x+10);
			maxY=Math.max(maxY, y+10);
			
			for (int x1 = 0; x1 < 10; x1++) {
				for (int y1 = 0; y1 < 10; y1++) {
					if (x+x1<100 && y+y1<100)
						map[x+x1][y+y1]++;
				}
			}
		}
		
		int result = N*100;
		int minus = 0;
				
		for (int i = 0; i < maxX; i++) {
			for (int j = 0; j < maxY; j++) {
				if (map[i][j]>1) {
					minus += (map[i][j]-1);
				}
			}
		}
		
		result -= minus;
		System.out.println(result);
	}

}

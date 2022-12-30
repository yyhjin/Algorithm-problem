import java.util.Arrays;
import java.util.Scanner;

public class Main_1003_피보나치함수 {

	static int N, test;
	static int[][] count;
	
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		
		int T = scann.nextInt();
		for (int t = 0; t < T; t++) {
			N = scann.nextInt();
			count = new int[N+2][2];
			
			for (int i = 0; i < N+2; i++) {
				Arrays.fill(count[i], -1);
			}
				
			count[0][0] = 1;
			count[0][1] = 0;
			count[1][0] = 0;
			count[1][1] = 1;
			
			fibo(N);
			System.out.println(count[N][0] + " " + count[N][1]);
		}

	}

	private static int[] fibo(int n) {
		if (count[n][0] == -1  && count[n][1] == -1){
			count[n][0] = fibo(n-1)[0] + fibo(n-2)[0];
			count[n][1] = fibo(n-1)[1] + fibo(n-2)[1];
		}
		
		return count[n];	
	}

}

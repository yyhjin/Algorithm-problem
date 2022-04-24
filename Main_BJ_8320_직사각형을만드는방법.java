package Backjoon;

import java.util.Scanner;

public class Main_BJ_8320_직사각형을만드는방법 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int count = N;
		int same = 0;
		for (int i = N/2; i > 1 ; i--) {
			for (int j = 2; ; j++) {
				if (i*j <= N) {
					count++; 
					if (i!=j) same++;
				}
				else break;
			}
		}
		System.out.println(count-(same/2));
	}
}

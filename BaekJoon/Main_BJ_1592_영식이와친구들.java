package Backjoon;

import java.util.Scanner;

public class Main_BJ_1592_영식이와친구들 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int L = sc.nextInt();
		
		int[] circle = new int[N];
		int cnt = -1;
		
		Loop:
		while(true) {
			for (int i = 0; i < N;) {
				circle[i]++;
				cnt++;
				if (circle[i]==M) break Loop;
				if (circle[i]%2==1) {
					i = (i+L)% N; 
				}
				else if (circle[i]%2==0) {
					i = (i-L)% N;
					if (i<0) i += N;
				}
			}
		}
		System.out.println(cnt);
	}

}

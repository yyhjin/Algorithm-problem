package Backjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main_BJ_11399_ATM {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] num = new int[N];
		
		for (int i = 0; i < N; i++) {
			num[i] = sc.nextInt();
		}
		
		Arrays.sort(num);
		
		int sum = 0;
		int n = N;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < n; j++) {
				sum += num[j];
			}
			n--;
		}
		System.out.println(sum);
	}

}

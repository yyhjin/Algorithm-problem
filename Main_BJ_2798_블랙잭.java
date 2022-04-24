package Backjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main_BJ_2798_블랙잭 {

	static int N;
	static int M;
	static int[] card;
	static int[] choice = new int[3];
	static int min = Integer.MAX_VALUE;
	static int result;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		card = new int[N];
		for (int i = 0; i < N; i++) {
			card[i] = sc.nextInt();
		}
		
		blackjack(0,0);
		System.out.println(result);
	}

	private static void blackjack(int start, int cnt) {
		if (cnt==3) {
			int sum = 0;
			for (int i = 0; i < 3; i++) {
				sum += choice[i];
			}
			if (sum <= M) {
				int minus = M-sum;
				if (minus < min) {
					min = Math.min(min, minus);
					result = sum;
				}
			}
			return;
		}
		for (int i = start; i < N; i++) {
			choice[cnt] = card[i];
			blackjack(i+1, cnt+1);
		}
	}

}

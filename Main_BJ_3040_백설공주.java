package hwalgo09_서울_15반_윤혜진;

import java.util.Scanner;

public class Main_BJ_3040_백설공주 {

	static int[] p = new int[9];
	static int[] num = new int[7];
	
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		
		for (int i = 0; i < 9; i++) {
			p[i]=scann.nextInt();
		}
		
		combi(0,0);
	}

	private static void combi(int cnt, int start) {
		if (cnt==7) {
			int sum=0;
			for (int i = 0; i < 7; i++) {
				sum += num[i];
			}
			if (sum==100) {
				for (int i = 0; i < 7; i++) {
					System.out.println(num[i]);
				}
			}
			return;
		}
		for (int i = start; i < 9; i++) {
			num[cnt] = p[i];
			combi(cnt+1, i+1);
		}
	}
	
}

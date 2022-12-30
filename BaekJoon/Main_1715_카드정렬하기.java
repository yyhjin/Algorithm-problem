package Backjoon;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main_1715_카드정렬하기 {

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		int N = scann.nextInt();
		for (int i = 0; i < N; i++) {
			pq.add(scann.nextInt());
		}

		int sum = 0;
		while (pq.size() >= 2) {
			int a = pq.poll();
			int b = pq.poll();

			int two = a + b;
			sum += two;
			pq.add(two);
		}
		System.out.println(sum);
	}
}

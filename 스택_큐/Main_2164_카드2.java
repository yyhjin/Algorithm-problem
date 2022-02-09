package 스택_큐;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_2164_카드2 {

	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<>();
		Scanner scann = new Scanner(System.in);
		
		int N = scann.nextInt();
		for (int i = 1; i <= N; i++) {
			q.add(i);
		}

		while (q.size()!=1) {
			q.remove();
			int top = q.poll();
			q.add(top);
		}
		System.out.println(q.poll());
	}

}

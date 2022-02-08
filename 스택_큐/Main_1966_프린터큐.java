package 스택_큐;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_1966_프린터큐 {

	public static void main(String[] args) {
		int T;
		int N;
		int M;
		LinkedList<int[]> q = new LinkedList<int[]>();

		Scanner scann = new Scanner(System.in);
		T = scann.nextInt(); // 테스트케이스 개수

		for (int t = 0; t < T; t++) {
			q.clear();
			int count = 0; // 출력 순서
			N = scann.nextInt(); // 문서 개수
			M = scann.nextInt(); // 궁금한 문서 번호
			for (int i = 0; i < N; i++) { // 문서 중요도
				int pri = scann.nextInt();
				q.add(new int[] { i, pri }); // {인덱스번호, 중요도}
			}

			while (true) {
				boolean max = true;
				int[] front = q.poll(); 

				//큐에 front보다 큰 값 있으면 front를 큐에 저장
				for (int i = 0; i < q.size(); i++) { 
					if (q.get(i)[1] > front[1]) {
						q.add(front);
						max = false;
						break;
					}
				}
				//front가 제일 큰 값이 아니면 다시 반복문 돌림
				if (!max) 
					continue;

				//front가 제일 큰 값일 경우, 해당 문서인지 체크
				else if (max) {
					count++;
					if (front[0] == M)
						break;
				}

			}
			System.out.println(count);
		}
	}
}

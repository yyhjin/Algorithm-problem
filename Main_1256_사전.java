package Backjoon;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Main_1256_사전 {

	static int N;
	static int M;
	static int K;

	static int R;
	static int count;
	static char[] s;

	static int[] sInt;

	static double m1 = 1;
	static boolean check = false;

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);

		N = scann.nextInt();
		M = scann.nextInt();
		K = scann.nextInt();

		s = new char[N + M];
		sInt = new int[N + M];

		for (int i = 0; i < N + M; i++) {
			sInt[i] = i;
		}

		combi(0, 0, new int[N], new boolean[N + M]);

		if (count < K)
			System.out.println(-1);

	}

	public static void combi(int cnt, int start, int[] num, boolean[] v) {
		// 중복조합 = N+M C N
		if (cnt == N) {
			if (check == false) {
				count++;
				// System.out.print(count+" ");
				// System.out.println(Arrays.toString(num));
				if (count == K) {
					char[] result = new char[N + M];
					for (int i = 0; i < N + M; i++) {
						result[i] = 'z';
						for (int y : num) {
							result[y] = 'a';
						}
					}
					check = true;
					System.out.println(result);
				}

				return;
			}
			else
				return;
		}
		for (int i = start; i < N + M; i++) {
			if (check == true) return;
			v[i] = true;
			num[cnt] = sInt[i];
			combi(cnt + 1, i + 1, num, v);
			v[i] = false;
		}
	}
}

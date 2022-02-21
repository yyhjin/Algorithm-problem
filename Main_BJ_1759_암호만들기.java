package hwalgo15_서울_15반_윤혜진;
import java.util.Arrays;
import java.util.Scanner;

public class Main_BJ_1759_암호만들기 {

	static int R;
	static int N;
	static char[] list, pwd;

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		R = scann.nextInt();
		N = scann.nextInt();
		list = new char[N];
		pwd = new char[R];

		for (int i = 0; i < N; i++) {
			list[i] = scann.next().charAt(0);
		}

		Arrays.sort(list);

		combi(0, 0);
	}

	private static void combi(int cnt, int start) {
		if (cnt == R) {
			if (check(pwd)) {
				for (int i = 0; i < pwd.length; i++) {
					System.out.print(pwd[i]);
				}
				System.out.println();
			}
			return;
		}
		for (int i = start; i < N; i++) {
			pwd[cnt] = list[i];
			combi(cnt + 1, i + 1);
		}
	}

	private static boolean check(char[] passwd) {
		int j=0;
		int m=0;
		for (char c : passwd) {
			if (c=='a' || c=='e' || c=='i' || c=='o' || c=='u')
				m++;
			else
				j++;
		}
		if (j>=2 && m>=1) 
			return true;
		else 
			return false;
		
	}

}

package Backjoon;
import java.util.Scanner;

public class Main_2941_크로아티아알파벳 {

	public static void main(String[] args) {
		String[] alpha = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };

		Scanner scann = new Scanner(System.in);
		String s = scann.next();

		for (int i = 0; i < alpha.length; i++) {
			if (s.contains(alpha[i])) {
				s = s.replace(alpha[i], "1");
			}
		}
		System.out.println(s.length());

	}

}

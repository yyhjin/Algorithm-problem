import java.util.Scanner;

public class Main_2440_별찍기3 {

	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		int N=scann.nextInt();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N-i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}

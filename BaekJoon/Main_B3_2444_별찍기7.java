import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B3_2444_별찍기7 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		int num = 1;
		for (int i = N-1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < num; j++) {
				System.out.print("*");
			}
			System.out.println();
			num += 2;
		}
		
		num -= 4;
		
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < num; j++) {
				System.out.print("*");
			}
			System.out.println();
			num -= 2;
		}
	}

}

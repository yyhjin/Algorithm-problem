import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_B2_5576_콘테스트 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] a = new int[10];
		int[] b = new int[10];
		
		for (int i = 0; i < 10; i++) {
			a[i] = Integer.parseInt(br.readLine());
		}
		for (int i = 0; i < 10; i++) {
			b[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(a);
		Arrays.sort(b);
		
		int sum1 = a[7]+a[8]+a[9];
		int sum2 = b[7]+b[8]+b[9];
		
		System.out.println(sum1+" "+sum2);
	}
}
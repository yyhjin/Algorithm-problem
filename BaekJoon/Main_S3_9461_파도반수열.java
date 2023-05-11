import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_S3_9461_파도반수열 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		long[] num = new long[101];
		num[1] = 1;
		num[2] = 1;
		num[3] = 1;
		for (int i = 4; i < 101; i++) {
			num[i] = num[i-3] + num[i-2];
		}
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			sb.append(num[n]+"\n");
		}
		System.out.println(sb);
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B4_4470_줄번호 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		for (int t = 1; t <= N; t++) {
			sb.append(t+". ")
				.append(br.readLine())
				.append("\n");
		}

		System.out.println(sb);
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B5_25314_코딩은_체육과목_입니다 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		for (int i = 1; i <= N; i+=4) {
			sb.append("long ");
		}
		sb.append("int");
		System.out.println(sb);
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B2_2908_상수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		sb.append(st.nextToken());
		sb.reverse();
		
		int a = Integer.parseInt(sb.toString());
		sb.setLength(0);
		sb.append(st.nextToken());
		sb.reverse();
		int b = Integer.parseInt(sb.toString());
		
		int max = Math.max(a, b);
		System.out.println(max);
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S5_11723_집합 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int M = Integer.parseInt(br.readLine());
		boolean[] S = new boolean[21];
		for (int t = 0; t < M; t++) {
			st = new StringTokenizer(br.readLine());
			String order = st.nextToken();
			
			if(order.equals("add")) {
				int x = Integer.parseInt(st.nextToken());
				S[x] = true;
			}
			else if(order.equals("remove")) {
				int x = Integer.parseInt(st.nextToken());
				S[x] = false;
			}
			else if(order.equals("check")) {
				int x = Integer.parseInt(st.nextToken());
				sb.append(S[x]?"1\n":"0\n");
			}
			else if(order.equals("toggle")) {
				int x = Integer.parseInt(st.nextToken());
				S[x] = !S[x];
			}
			else if(order.equals("all")) {
				Arrays.fill(S, true);
			}
			else if(order.equals("empty")) {
				Arrays.fill(S, false);
			}
		}
		
		System.out.println(sb);
	}

}

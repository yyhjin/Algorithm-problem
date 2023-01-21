import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B3_10250_ACM호텔 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			
			int q = N/H;
			int r = N%H;
			
			if(r == 0) {
				sb.append(H);
				if(q < 10) sb.append(0).append(q);
				else sb.append(q);
			}
			else {
				sb.append(r);
				if(q+1 < 10) sb.append(0).append(q+1);
				else sb.append(q+1);
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

}

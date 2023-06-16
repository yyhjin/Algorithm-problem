import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B3_3058_짝수를찾아라 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		int sum = 0;
		int min = Integer.MAX_VALUE;
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			sum = 0;
			min = Integer.MAX_VALUE;
			
			for (int i = 0; i < 7; i++) {
				int n = Integer.parseInt(st.nextToken());
				if(n%2 == 0) {
					sum += n;
					min = Math.min(min, n);
				}
			}
			sb.append(sum+" "+min+"\n");
		}
		
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}

}

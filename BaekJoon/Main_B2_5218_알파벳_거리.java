import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B2_5218_알파벳_거리 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		for (int t = 0; t < N; t++) {
			st = new StringTokenizer(br.readLine());
			String word1 = st.nextToken();
			String word2 = st.nextToken();
			
			sb.append("Distances: ");
			for (int i = 0; i < word1.length(); i++) {
				int x = word1.charAt(i)-'0';
				int y = word2.charAt(i)-'0';
				
				if(x > y) {
					sb.append((y+26)-x).append(" ");
				}
				else sb.append(y-x).append(" ");
			}
			
			sb.setLength(sb.length()-1);
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

}

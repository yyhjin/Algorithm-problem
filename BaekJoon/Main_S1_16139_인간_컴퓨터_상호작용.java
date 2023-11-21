import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S1_16139_인간_컴퓨터_상호작용 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		String S = br.readLine();
		int q = Integer.parseInt(br.readLine());
		int[][] cnt = new int[26][S.length()+1];
		
		for (int i = 0; i < S.length(); i++) {
			char c = S.charAt(i);
			
			for (int j = 0; j < 26; j++) {
				cnt[j][i+1] = cnt[j][i];
			}
			
			cnt[c-'a'][i+1]++;
		}
		
		for (int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine());
			
			char c = st.nextToken().charAt(0);
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken()) + 1;
						
			sb.append((cnt[c-'a'][b] - cnt[c-'a'][a]))
				.append("\n");
		}
		
		System.out.println(sb);
	}

}

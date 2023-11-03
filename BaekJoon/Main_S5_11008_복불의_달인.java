import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S5_11008_복불의_달인 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			StringBuilder str = new StringBuilder(st.nextToken().toString());
			String keyword = st.nextToken();
			
			int time = 0;
			int len = keyword.length();
			while(str.indexOf(keyword) != -1) {
				time++;
				int index = str.indexOf(keyword);
				str.delete(index, index+len);
			}
			time += str.length();
			sb.append(time+"\n");
		}

		System.out.println(sb);
	}

}

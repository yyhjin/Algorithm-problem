import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main_S5_11645_Ive_Been_Everywhere_Man {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			Map<String, Integer> hash = new HashMap<>();
			
			for (int i = 0; i < N; i++) {
				String word = br.readLine();
				hash.put(word, hash.getOrDefault(word, 0)+1);
			}
			
			sb.append(hash.size()+"\n");
		}
		
		System.out.println(sb);
	}

}

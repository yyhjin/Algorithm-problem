import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_S3_20291_파일정리 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		HashMap<String, Integer> hash = new HashMap<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken(".");
			String type = st.nextToken();
			
			hash.put(type, hash.getOrDefault(type, 0)+1);
		}

		ArrayList<String> keys = new ArrayList<>();
		for(String key : hash.keySet()) {
			keys.add(key);
		}
		
		Collections.sort(keys);
		for(String key : keys) {
			sb.append(key+" "+hash.get(key)+"\n");
		}
		
		System.out.println(sb);
	}

}

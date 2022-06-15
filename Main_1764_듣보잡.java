import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_1764_듣보잡 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		Map<String, Integer> map = new HashMap<>();
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			String name = br.readLine();
			map.put(name, 1);
		}
		for (int i = 0; i < M; i++) {
			String name = br.readLine();
			map.put(name, map.getOrDefault(name, 0)+1);
		}
		
		Object[] keys = map.keySet().toArray();
		Arrays.sort(keys);
		
		int count = 0;
		for (Object key : keys) {
			if(map.get(key)==2) {
				count++;
				sb.append(key+"\n");
			}
		}
		System.out.println(count);
		System.out.println(sb);
	}

}

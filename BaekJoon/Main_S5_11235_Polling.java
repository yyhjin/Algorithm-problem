import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main_S5_11235_Polling {

	public static void main(String[] args)  throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Map<String, Integer> hash = new HashMap<>();
		
		int max = 0;
		for (int i = 0; i < N; i++) {
			String name = br.readLine();
			hash.put(name, hash.getOrDefault(name, 0)+1);
			max = Math.max(max, hash.get(name));
		}
		
		List<String> list = new ArrayList<>();
		for(String s: hash.keySet()) {
			int cnt = hash.get(s);
			if(cnt == max) list.add(s);
		}
		
		Collections.sort(list);
		for(String s: list) {
			System.out.println(s);
		}
		
	}

}

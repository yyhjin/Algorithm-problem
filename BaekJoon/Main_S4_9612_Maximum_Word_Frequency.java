import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main_S4_9612_Maximum_Word_Frequency {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Map<String, Integer> hash = new HashMap<>();

		int max = 0;
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			hash.put(s, hash.getOrDefault(s, 0)+1);
			max = Math.max(max, hash.get(s));
		}
		
		ArrayList<String> arr = new ArrayList<>();
		for(String s : hash.keySet()) {
			int freq = hash.get(s);
			if(freq == max) arr.add(s);
		}
		
		Collections.sort(arr, Collections.reverseOrder());
		System.out.println(arr.get(0) + " " + max);
	}

}

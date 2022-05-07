import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main_5052_전화번호목록 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, Integer> hash = new HashMap<>();
		String answer = "";
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			hash.clear();
			answer = "";	
			
			int N = Integer.parseInt(br.readLine());
			for (int i = 0; i < N; i++) {
				hash.put(br.readLine(), 0);
			}

			loop: 
			for (String phone : hash.keySet()) {
				for (int i = 0; i < phone.length(); i++) {
					String sub = phone.substring(0, i);

					if (hash.containsKey(sub)) {
						answer = "NO";
						break loop;
					}

				}
			}
			
			if(answer=="") answer = "YES";
			System.out.println(answer);
		}

	}

}

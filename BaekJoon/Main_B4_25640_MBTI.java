import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main_B4_25640_MBTI {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		HashMap<String, Integer> hash = new HashMap<>();
		String jinho = br.readLine();
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			String friend = br.readLine();
			hash.put(friend, hash.getOrDefault(friend, 0)+1);
		}

		System.out.println(hash.getOrDefault(jinho, 0));
	}

}

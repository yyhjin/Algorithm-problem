import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_B2_22966_가장쉬운문제를찾는문제 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		HashMap<Integer, String> hash = new HashMap<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			int level = Integer.parseInt(st.nextToken());
			hash.put(level, s);
		}
		
		Object[] keys = hash.keySet().toArray();
		Arrays.sort(keys);
		
		System.out.println(hash.get(keys[0]));
	}

}

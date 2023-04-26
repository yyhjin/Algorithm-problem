import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_S5_25757_임스와함께하는미니게임 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		String game = st.nextToken();
		int person = -1;
		
		if(game.equals("Y")) person = 2;
		else if(game.equals("F")) person = 3;
		else person = 4;
		
		HashMap<String, Integer> hash = new HashMap<>();
		int cnt = 1;
		int result = 0;
		
		for (int i = 0; i < N; i++) {
			String name = br.readLine();
			if(hash.containsKey(name)) continue;
			hash.put(name, 1);
			cnt++;
			if(cnt == person) {
				result++;
				cnt = 1;
			}
		}
		
		System.out.println(result);
	}

}

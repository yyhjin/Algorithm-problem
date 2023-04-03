import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main_B1_1157_단어공부 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String word = br.readLine();
		word = word.toUpperCase();
		HashMap<Character, Integer> hash = new HashMap<>();
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			hash.put(c, hash.getOrDefault(c, 0)+1);
		}
		
		char result = ' ';
		int max = 0;
		boolean same = false;
		for(char alpha: hash.keySet()) {
			int cnt = hash.get(alpha);
			if(cnt > max) {
				result = alpha;
				max = cnt;
				same = false;
			}
			else if(cnt == max) same = true;
		}
		
		System.out.println(same?'?':result);
	}

}

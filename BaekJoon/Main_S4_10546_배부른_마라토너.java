import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main_S4_10546_배부른_마라토너 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		HashMap<String, Integer> hash = new HashMap<>();
		
		for (int i = 0; i < N; i++) {
			String name = br.readLine();
			hash.put(name, hash.getOrDefault(name, 0)+1);
		}
		
		for (int i = 0; i < N-1; i++) {
			String name = br.readLine();
			if(hash.get(name) == 1) hash.remove(name);
			else hash.put(name, hash.get(name)-1);
		}
		
		for(String s : hash.keySet()) System.out.println(s);
	}

}

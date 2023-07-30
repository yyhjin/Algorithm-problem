import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_S5_25206_너의_평점은 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		HashMap<String, Double> hash = new HashMap<>();
		hash.put("A+", 4.5);
		hash.put("A0", 4.0);
		hash.put("B+", 3.5);
		hash.put("B0", 3.0);
		hash.put("C+", 2.5);
		hash.put("C0", 2.0);
		hash.put("D+", 1.5);
		hash.put("D0", 1.0);
		hash.put("F", 0.0);
		
		double result = 0;
		double all = 0;
		for (int i = 0; i < 20; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			double time = Double.parseDouble(st.nextToken());
			String score = st.nextToken();
			
			if(score.equals("P")) continue;
			
			all += time;
			result += (time*hash.get(score));
		}
		
		System.out.println(result/all);
	}

}

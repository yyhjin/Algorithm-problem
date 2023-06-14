import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_S4_26069_붙임성좋은총총이 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		HashSet<String> dance = new HashSet<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String p1 = st.nextToken();
			String p2 = st.nextToken();
			
			if(dance.contains(p1) || dance.contains(p2) 
					|| p1.equals("ChongChong") || p2.equals("ChongChong")) {
				dance.add(p1);
				dance.add(p2);
			}
		}
		
		System.out.println(dance.size());
	}

}

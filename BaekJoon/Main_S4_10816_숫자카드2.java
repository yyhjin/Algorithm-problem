import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_S4_10816_숫자카드2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		HashMap<Integer, Integer> map = new HashMap<>();
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			map.put(num, map.getOrDefault(num, 0)+1);
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int find = Integer.parseInt(st.nextToken());
			
			if(map.containsKey(find)) {
				sb.append(map.get(find)+" ");
			}
			else
				sb.append(0+" ");
		}

		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}

}

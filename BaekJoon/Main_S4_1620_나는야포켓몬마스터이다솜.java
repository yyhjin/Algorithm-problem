import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_S4_1620_나는야포켓몬마스터이다솜 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<Integer, String> map_idx = new HashMap<>();
		HashMap<String, Integer> map_name = new HashMap<>();
		
		for (int i = 1; i <= N; i++) {
			String pocketmon = br.readLine();
			map_idx.put(i, pocketmon);
			map_name.put(pocketmon, i);
		}
		
		for (int i = 0; i < M; i++) {
			String find = br.readLine();
			
			if(map_name.containsKey(find)) {
				sb.append(map_name.get(find)+"\n");
			}
			else {
				sb.append(map_idx.get(Integer.parseInt(find))+"\n");
			}
		}
		
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}

}

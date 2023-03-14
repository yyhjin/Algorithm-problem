import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_S5_7785_회사에있는사람 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		HashMap<String, Integer> map = new HashMap<>();
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			String status = st.nextToken();
			
			if(status.equals("enter")) map.put(name, 1);
			else map.remove(name);
		}

		LinkedList<String> keys = new LinkedList<>();
		for(String name: map.keySet()) {
			keys.add(name);
		}
		
		Collections.sort(keys, Collections.reverseOrder());
		for(String key : keys) {
			sb.append(key+"\n");
		}
		
		System.out.println(sb);
	}

}

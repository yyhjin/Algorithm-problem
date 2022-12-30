import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_19583_싸이버개강총회 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Map<String, Integer> map = new HashMap<>();

		st = new StringTokenizer(br.readLine());
		String s = st.nextToken();
		String e = st.nextToken();
		String q = st.nextToken();

		int S, E, Q;

		st = new StringTokenizer(s, ":");
		String si = st.nextToken();
		String bun = st.nextToken();
		S = Integer.parseInt(si + bun);

		st = new StringTokenizer(e, ":");
		si = st.nextToken();
		bun = st.nextToken();
		E = Integer.parseInt(si + bun);

		st = new StringTokenizer(q, ":");
		si = st.nextToken();
		bun = st.nextToken();
		Q = Integer.parseInt(si + bun);

		String line = "";
		while ((line = br.readLine()) != null) {
			st = new StringTokenizer(line);
			String time = st.nextToken();
			String nickname = st.nextToken();

			st = new StringTokenizer(time, ":");
			si = st.nextToken();
			bun = st.nextToken();
			int t = Integer.parseInt(si + bun);

			if (t <= S)
				map.put(nickname, 1);

			if (map.containsKey(nickname) && (t >= E && t <= Q))
				map.put(nickname, map.get(nickname) + 1);

		}

		int count = 0;
		for (String key : map.keySet()) {
			if (map.get(key) >= 2)
				count++;
		}
		System.out.println(count);

	}

}

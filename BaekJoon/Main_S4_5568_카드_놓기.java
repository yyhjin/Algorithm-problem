import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main_S4_5568_카드_놓기 {

	static int N, K;
	static int[] card, choice;
	static boolean[] v;
	static Set<String> set = new HashSet<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		card = new int[N];
		choice = new int[K];
		v = new boolean[N];

		for (int i = 0; i < N; i++) {
			card[i] = Integer.parseInt(br.readLine());
		}
		
		perm(0);
		System.out.println(set.size());
	}

	private static void perm(int cnt) {
		if(cnt == K) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < K; i++) {
				sb.append(choice[i]);
			}
			set.add(sb.toString());
			return;
		}
		for (int i = 0; i < N; i++) {
			if(v[i]) continue;
			
			v[i] = true;
			choice[cnt] = card[i];
			perm(cnt+1);
			v[i] = false;
		}
	}

}

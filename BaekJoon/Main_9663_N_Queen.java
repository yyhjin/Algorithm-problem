import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9663_N_Queen {

	static int N, count;
	static int[] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N];
		
		dfs(0);
		System.out.println(count);
	}

	private static void dfs(int cnt) {
		if (cnt==N) {
			count++;
			return;
		}
		for (int i = 0; i < N; i++) {
			if(check(cnt, i)) {
				map[cnt] = i;
				dfs(cnt+1);
			}
		}
		
	}

	private static boolean check(int cnt, int index) {
		for (int i = 0; i < cnt; i++) {
			if(map[i]==index) return false;
			if(Math.abs(i-cnt) == Math.abs(map[i]-index)) return false;
		}
		return true;
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S2_10819_차이를최대로 {
	
	static int N, max;
	static int[] arr, choice;
	static boolean[] v;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		choice = new int[N];
		v = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		perm(0);
		System.out.println(max);
	}

	private static void perm(int cnt) {
		if(cnt == N) {
			int sum = 0;
			for (int i = 1; i < N; i++) {
				sum += Math.abs(choice[i-1] - choice[i]);
			}
			max = Math.max(max, sum);
			return;
		}
		for (int i = 0; i < N; i++) {
			if(v[i]) continue;
			
			v[i] = true;
			choice[cnt] = arr[i];
			perm(cnt+1);
			v[i] = false;
		}
	}

}

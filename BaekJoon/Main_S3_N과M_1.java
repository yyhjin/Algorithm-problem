import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S3_N과M_1 {

	static int N, M;
	static int[] choice;
	static boolean[] v;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		choice = new int[M+1];
		v = new boolean[N+1];
		
		perm(0);
	}

	private static void perm(int cnt) {
		if(cnt == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(choice[i]+" ");
			}
			System.out.println();
			return;
		}
		for(int i = 1; i <= N; i++) {
			if(v[i]) continue;
			
			choice[cnt] = i;
			v[i] = true;
			perm(cnt+1);
			v[i] = false;
		}
	}

}

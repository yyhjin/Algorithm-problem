import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S3_15650_N과M_2 {

	static int N, M;
	static boolean[] v;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		v = new boolean[N+1];
		
		comb(1,0);
	}

	private static void comb(int start, int cnt) {
		if(cnt == M) {
			for(int i = 1; i <= N; i++) {
				if(v[i]) System.out.print(i+" ");
			}
			System.out.println();
			
			return;
		}
		for(int i = start; i <= N; i++) {
			if(v[i]) continue;
			
			v[i] = true;
			comb(i, cnt+1);
			v[i] = false;
		}
	}

}

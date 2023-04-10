import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S3_15651_N과M_3 {

	static int N, M;
	static int[] choice;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		choice = new int[N+1];
		
		perm(0);
		System.out.println(sb);
	}

	// 중복 순열이므로 방문 배열 없음
	private static void perm(int cnt) {
		if(cnt == M) {
			for(int i = 0; i < M; i++) {
				sb.append(choice[i]+" ");
			}
			sb.append("\n");
			return;
		}
		for(int i = 1; i <= N; i++) {
			choice[cnt] = i;
			perm(cnt+1);
		}
	}

}

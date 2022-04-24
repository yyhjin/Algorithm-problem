import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2458_키순서 {

	static int N, M;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][N+1]; //패딩, 0 사용X
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = 1;
		}
		
		// 플로이드 워셜
		for (int k = 1; k < N+1; k++) {  //경유
			for (int i = 1; i < N+1; i++) {  //출발
				if (i==k) continue;
				for (int j = 1; j < N+1; j++) {  //도착
					if (j==i) continue;
					if (map[i][k]==1 && map[k][j]==1)
						map[i][j] = 1;
				}
			}
		}
		
		int[] cnt = new int[N+1]; // 자신보다 작거나 큰 노드의 개수 합쳐서 저장
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < N+1; j++) {
				if (map[i][j]==1) {
					cnt[i]++;  // 자신보다 작은 노드
					cnt[j]++;  // 자신보다 큰 노드
				}
			}
		}
		
		int count = 0;
		for (int i = 1; i < N+1; i++) {
			if (cnt[i]==N-1)
				count++;
		}
		
		System.out.println(count);
	}

}

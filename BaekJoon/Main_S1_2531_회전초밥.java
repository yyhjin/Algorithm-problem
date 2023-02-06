import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S1_2531_회전초밥 {

	static int N, D, K, C;
	static int[] dish, v;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		dish = new int[N + K - 1];
		v = new int[D + 1];
		
		for (int i = 0; i < N; i++) {
			dish[i] = Integer.parseInt(br.readLine());
		}

		// 원형이니까 1차원 배열로 이어붙이기
		for (int i = N, j = 0; i < N + K - 1; i++, j++) {
			dish[i] = dish[j];
		}
		
		// 0 ~ K 까지
		int count = 0;
		for (int i = 0; i < K; i++) {
			if (v[dish[i]] == 0)
				count++;
			v[dish[i]]++;
		}
		
		int max = count;
		int start = 1;
		int end = K;
		while(start<N && end<N+K-1) {
			if(v[dish[start-1]]==1) count--;
			v[dish[start-1]]--;
			
			if(v[dish[end]]==0) count++;
			v[dish[end]]++;
			
			if (v[C] == 0)  // 쿠폰 초밥 안먹었으면
				max = Math.max(max, count+1);
			else   // 쿠폰 초밥 먹었으면
				max = Math.max(max, count);
			
			start++;
			end++;			
		}
		
		System.out.println(max);
		
	}
		
}

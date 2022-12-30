import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_2660_회장뽑기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[][] nums = new int[N+1][N+1];
		
		// 초기화
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(i==j) continue;
				nums[i][j] = 9999999;
			}
		}
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(a==-1 && b==-1) break;
			
			nums[a][b] = 1;
			nums[b][a] = 1;
		}
		
		for (int k = 1; k < N+1; k++) { // 경유
			for (int i = 1; i < N+1; i++) { // 출발
				if(i==k) continue;
				for (int j = 1; j < N+1; j++) { // 도착
					if(j==i || j==k) continue;
					if(nums[i][j] > nums[i][k] + nums[k][j])
						nums[i][j] = nums[i][k] + nums[k][j];
				}
			}
		}
		
		int score = Integer.MAX_VALUE;
		int count = 0;
		
		// 최대 점수 맨 앞에 저장
		for (int i = 1; i < N+1; i++) {
			int max = 0;
			for (int j = 1; j < N+1; j++) {
				if(nums[i][j]==0) continue;
				max = Math.max(max, nums[i][j]);
			}
			nums[i][0] = max;
			score = Math.min(score, max);
		}
		
		
		for (int i = 1; i < N+1; i++) {
			if(nums[i][0]==score) 
				count++;
		}
		sb.append(score+" "+count+"\n");
		
		for (int i = 1; i < N+1; i++) {
			if(nums[i][0]==score) 
				sb.append(i+" ");
		}
		
		sb.setLength(sb.length()-1);
		System.out.println(sb);
		
	}

}

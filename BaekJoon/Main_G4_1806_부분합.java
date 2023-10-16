import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G4_1806_부분합 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int[] arr = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
		}
		
		int min = Integer.MAX_VALUE;
		int left = 1;
		int right = 1;
		while(right<=N && left<=right) {
			int sum = arr[right] - arr[left-1];
			
			if(sum >= S) {
				min = Math.min(min, right-left+1);
				left++;
			}
			else if(sum < S) {
				right++;
			}
		}
		
		System.out.println(min==Integer.MAX_VALUE?0:min);
	}

}

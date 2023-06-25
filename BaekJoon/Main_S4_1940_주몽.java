import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S4_1940_주몽 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[] nums = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);
		
		int count = 0;
		int left = 0;
		int right = N-1;
		while(left < right) {
			int sum = nums[left] + nums[right];
			
			if(sum == M) {
				count++;
				left++;
			}
			else if(sum > M) right--;
			else if(sum < M) left++;
		}
		
		System.out.println(count);
	}

}

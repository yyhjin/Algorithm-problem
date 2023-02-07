import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G5_2470_두용액 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] nums = new int[N];
		
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);
		
		int a = -1;
		int b = -1;
		int min = Integer.MAX_VALUE;
		
		int left = 0;
		int right = N-1;
		while(left < right) {
			int sum = nums[left] + nums[right];
			if(Math.abs(sum) < Math.abs(min)) {
				min = sum;
				a = nums[left];
				b = nums[right];
			}
			
			if(sum > 0) right--;
			else left++;
		}
		
		System.out.println(a+" "+b);

	}

}

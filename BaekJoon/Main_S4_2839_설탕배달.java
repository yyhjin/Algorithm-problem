import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_S4_2839_설탕배달 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N+1];
		Arrays.fill(nums, 987654321);
		
		for (int i = 3; i <= N; i++) {
			if(i == 3) nums[i] = 1;
			else if(i == 5) nums[i] = 1;
			else if(i>5){
				nums[i] = Math.min(nums[i-3]+1, nums[i-5]+1); 
			}
		}
		System.out.println(nums[N] >= 987654321?-1:nums[N]);
	}

}

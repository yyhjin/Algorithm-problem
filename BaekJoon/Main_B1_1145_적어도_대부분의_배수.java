import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_B1_1145_적어도_대부분의_배수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] nums = new int[5];
		for (int i = 0; i < 5; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);
		for (int i = 2; i < 1000000; i++) {
			int count = 0;
			for (int j = 0; j < 5; j++) {
				if(i % nums[j] == 0) count++;
			}
			if(count >= 3) {
				System.out.println(i);
				break;
			}
		}
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_B1_10989_수정렬하기3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(nums);
		
		for (int i = 0; i < N; i++) {
			sb.append(nums[i]+"\n");
		}
		
		sb.setLength(sb.length()-1);
		System.out.println(sb);

	}

}

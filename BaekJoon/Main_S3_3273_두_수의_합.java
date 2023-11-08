import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S3_3273_두_수의_합 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);	
		int X = Integer.parseInt(br.readLine());

		int count = 0;
		int left = 0;
		int right = N-1;
		while(left<right && right<N) {
			int sum = arr[left] + arr[right];
			
			if(sum == X) {
				count++;
				left++;
			}
			else if(sum < X) left++;
			else right--;
		}
		
		System.out.println(count);
	}

}

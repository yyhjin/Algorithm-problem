import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S3_21921_블로그 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int[] num = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N+1; i++) {
			num[i] = num[i-1] + Integer.parseInt(st.nextToken());
		}
		
		int max = 0;
		int count = 1;
		int left = 0;
		int right = X;
		while(left<=right && right<N+1) {
			int sum = num[right] - num[left];
			
			if(sum > max) count = 1;
			else if(sum == max) count++;
			max = Math.max(max, sum);
			right++;
			left++;
		}
		
		System.out.println(max==0?"SAD":max+"\n"+count);
	}

}

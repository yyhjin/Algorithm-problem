import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B1_1546_평균 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		double[] nums = new double[N];
		
		double max = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Double.parseDouble(st.nextToken());
			max = Math.max(max, nums[i]);
		}
		
		double avg = 0;
		for (int i = 0; i < N; i++) {
			avg += nums[i]/max*100;
		}
		
		avg /= N;
		System.out.println(avg);
	}

}

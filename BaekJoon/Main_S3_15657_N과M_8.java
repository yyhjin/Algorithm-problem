import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S3_15657_N과M_8 {

	static int N, M;
	static int[] nums, choice;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = new int[N];
		choice = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);
		
		combi(0,0);
		System.out.println(sb);
	}

	private static void combi(int start, int cnt) {
		if(cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(choice[i]+" ");
			}
			sb.setLength(sb.length()-1);
			sb.append("\n");
			return;
		}
		for (int i = start; i < N; i++) {
			choice[cnt] = nums[i];
			combi(i, cnt+1);
		}
	}

}

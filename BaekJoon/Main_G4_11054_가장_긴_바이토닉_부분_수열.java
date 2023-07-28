import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G4_11054_가장_긴_바이토닉_부분_수열 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+2];
		int[] up = new int[N+1];
		int[] down = new int[N+2];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 증가하는 수열
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < i; j++) {
				if(arr[i] > arr[j])
					up[i] = Math.max(up[i], up[j]+1);
			}
		}
		
		// 감소하는 수열
		// 뒤부터 증가하는 수열로 만들면 down[i]는 i 인덱스부터 시작하는 최장 감소 수열이 됨
		for (int i = N; i > 0; i--) {
			for (int j = N+1; j > i; j--) {
				if (arr[i] > arr[j])
					down[i] = Math.max(down[i], down[j]+1);
			}
		}
		
		int max = 0;
		for (int i = 1; i <= N; i++) {
			max = Math.max(max, up[i]+down[i]-1);
		}
		
		System.out.println(max);
	}

}

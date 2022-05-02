import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11497_통나무건너뛰기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			int[] map = new int[N];
			int[] tree = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[j] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(map);
			int left = 0;
			int right = N-1;
			for (int j = 0; j < N; j++) {
				if (j%2==0) {
					tree[left] = map[j];
					left++;
				}
				else {
					tree[right] = map[j];
					right--;
				}
			}
			
			int max = Integer.MIN_VALUE;
			for (int j = 0; j < N-1; j++) {
				int cha = Math.abs(tree[j] - tree[j+1]);
				max = Math.max(max, cha);
			}
			System.out.println(max);
			
		}

	}

}

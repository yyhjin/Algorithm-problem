import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_S3_19637_IF문좀대신써줘 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] power = new int[N];
		HashMap<Integer, String> map = new HashMap<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int p = Integer.parseInt(st.nextToken());
			
			power[i] = p;
			map.put(p, name);
		}
		
		for (int i = 0; i < M; i++) {
			int input = Integer.parseInt(br.readLine());
			
			int left = 0;
			int right = N-1;
			int resultIdx = -1;
			
			while(left <= right) {
				int mid = (left + right) / 2;
				
				if(power[mid] >= input) {
					right = mid-1;
					resultIdx = mid;
				}
				else left = mid+1;
			}
			
			sb.append(map.get(power[resultIdx])+"\n");
		}
		
		sb.setLength(sb.length()-1);
		System.out.println(sb);
		
	}

}

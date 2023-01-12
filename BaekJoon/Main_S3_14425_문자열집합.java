import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_S3_14425_문자열집합 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Set<String> map = new HashSet<>();
		
		for (int i = 0; i < N; i++) {
			map.add(br.readLine());
		}
		
		int count = 0;
		for (int i = 0; i < M; i++) {
			String s = br.readLine();
			
			if(map.contains(s)) {
				count++;
			}
		}
		
		System.out.println(count);

	}

}

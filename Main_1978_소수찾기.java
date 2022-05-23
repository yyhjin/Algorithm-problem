import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1978_소수찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());		
		st = new StringTokenizer(br.readLine());
		int count = 0;
		
		loop:
		for (int i = 0; i < N; i++) {
			int a = Integer.parseInt(st.nextToken());
			
			if(a==0 || a==1) continue;
			for (int j = 2; j <= a/2; j++) {
				if(a%j==0) continue loop;
			}
			count++;
		}
		System.out.println(count);
		
	}

}

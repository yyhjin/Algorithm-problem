import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B3_2566_최댓값 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int max = 0;
		int r = 0;
		int c = 0;
		
		for (int i = 1; i <= 9; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 9; j++) {
				int n = Integer.parseInt(st.nextToken());
				if(n > max) {
					max = n;
					r = i;
					c = j;
				}
			}
		}
		
		System.out.println(max);
		System.out.println(r+" "+c);
	}

}

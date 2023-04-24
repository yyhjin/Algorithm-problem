import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B3_23971_ZOAC4 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int r = 0;
		int c = 0;
		for (int i = 0; i < H; i+=N+1) {
			r++;
		}
		for (int i = 0; i < W; i+=M+1) {
			c++;
		}

		System.out.println(r*c);
	}

}

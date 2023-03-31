import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S2_16953_A_B {

	static long A, B;
	static int count;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		A = Long.parseLong(st.nextToken());
		B = Long.parseLong(st.nextToken());
		dfs(A, 1);
		
		if(count == 0) System.out.println(-1);
		else System.out.println(count);
	}

	private static void dfs(long n, int depth) {
		if(n>B) return;
		
		if(n==B) {
			count = depth;
			return;
		}
		
		dfs(n*2, depth+1);
		String s = Long.toString(n)+"1";
		Long next = Long.parseLong(s);
		dfs(next, depth+1);	
	}

}

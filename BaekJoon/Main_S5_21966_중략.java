import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S5_21966_중략 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		String S = br.readLine();
		
		if(N <= 25) System.out.println(S);
		else {
			int token = 0;
			st = new StringTokenizer(S.toString().substring(11, N-11), ".");
			while(st.hasMoreTokens()) {
				st.nextToken();
				token++;
			}
			
			if(token <= 1) System.out.println(S.substring(0, 11)+"..."+S.substring(N-11, N));
			else System.out.println(S.substring(0, 9)+"......"+S.substring(N-10, N));
		}

	}

}

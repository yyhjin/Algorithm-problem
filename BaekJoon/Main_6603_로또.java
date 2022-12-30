import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_6603_로또 {

	static int K;
	static int[] S, choice;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
	
		while(true) {
			st = new StringTokenizer(br.readLine());
			K = Integer.parseInt(st.nextToken());
			sb = new StringBuilder();
			if(K==0) break;
			
			S = new int[K];
			choice = new int[6];
			for (int i = 0; i < K; i++) {
				S[i] = Integer.parseInt(st.nextToken());
			}
			
			combi(0,0);
			System.out.println(sb);
		}

	}

	private static void combi(int cnt, int start) {
		if(cnt==6) {
			for (int i = 0; i < 6; i++) {
				sb.append(choice[i]+" ");
			}
			sb.setLength(sb.length()-1);
			sb.append("\n");
			return;
		}
		for (int i = start; i < K; i++) {
			choice[cnt] = S[i];
			combi(cnt+1, i+1);
		}
		
	}

}

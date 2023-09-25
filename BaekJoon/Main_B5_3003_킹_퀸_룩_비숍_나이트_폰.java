import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B5_3003_킹_퀸_룩_비숍_나이트_폰 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] answer = { 1, 1, 2, 2, 2, 8 };
		for (int i = 0; i < 6; i++) {
			System.out.print(answer[i] - Integer.parseInt(st.nextToken())+" ");
		}

	}

}

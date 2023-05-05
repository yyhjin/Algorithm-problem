import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B5_2739_구구단 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		for (int i = 1; i <= 9; i++) {
			sb.append(N+" * "+i+" = "+(N*i)+"\n");
		}
		System.out.println(sb);
	}

}

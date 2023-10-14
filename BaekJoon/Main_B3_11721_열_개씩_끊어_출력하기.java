import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B3_11721_열_개씩_끊어_출력하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String s = br.readLine();
		for (int i = 1; i <= s.length(); i++) {
			sb.append(s.charAt(i-1));
			if(i%10 == 0) sb.append("\n");
		}

		System.out.println(sb);
	}

}

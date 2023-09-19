import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B2_8958_OX퀴즈 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			String line = br.readLine();
			
			int count = 0;
			int sum = 0;
			for (int i = 0; i < line.length(); i++) {
				if(line.charAt(i) == 'O') count++;
				else count  = 0;
				
				sum += count;
			}
			sb.append(sum+"\n");
		}
		
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}

}

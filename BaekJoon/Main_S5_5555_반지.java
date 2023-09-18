import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_S5_5555_반지 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String keyword = br.readLine();
		int N = Integer.parseInt(br.readLine());
		
		int count = 0;
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			line += line.substring(0, line.length()-1);
			if(line.contains(keyword)) count++;
		}

		System.out.println(count);
	}

}

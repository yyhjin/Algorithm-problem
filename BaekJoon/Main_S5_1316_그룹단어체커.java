import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_S5_1316_그룹단어체커 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] alpha = new int[26];
		int count = 0;
		
		loop:
		for (int i = 0; i < N; i++) {
			Arrays.fill(alpha, 0);
			String word = br.readLine();
			
			char prev = ' ';
			for (int j = 0; j < word.length(); j++) {
				char c = word.charAt(j);
				if(alpha[c-97] == 0) {
					alpha[c-97]++;
					prev = c;
				}
				else {
					if(prev != c) continue loop;
					alpha[c-97]++;
				}
			}
			count++;
		}
		
		System.out.println(count);

	}

}

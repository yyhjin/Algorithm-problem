import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_B2_10809_알파벳_찾기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String word = br.readLine();
		int[] alpha = new int[26];
		Arrays.fill(alpha, -1);
		
		for (int i = 0; i < word.length(); i++) {
			int c = word.charAt(i) - 97;
			if(alpha[c] != -1) continue;
			else alpha[c] = i;
		}
		
		for (int i = 0; i < 26; i++) {
			System.out.print(alpha[i]+" ");
		}
	}

}

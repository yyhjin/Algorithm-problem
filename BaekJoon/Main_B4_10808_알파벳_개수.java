import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B4_10808_알파벳_개수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = br.readLine();
		int[] alpha = new int[26];
		
		for (int i = 0; i < line.length(); i++) {
			char c = line.charAt(i);
			alpha[c-'a']++;
		}
		
		for (int i = 0; i < 26; i++) {
			System.out.print(alpha[i]+" ");
		}
	}

}

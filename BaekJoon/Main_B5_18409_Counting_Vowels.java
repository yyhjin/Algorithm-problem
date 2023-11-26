import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B5_18409_Counting_Vowels {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String word = br.readLine();
		
		int count = 0;
		for (int i = 0; i < N; i++) {
			char c = word.charAt(i);
			if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u') count++;
		}
		
		System.out.println(count);
	}

}

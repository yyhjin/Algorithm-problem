import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B2_23037_5의수난 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		int sum = 0;
		
		for (int i = 0; i < s.length(); i++) {
			int num = Character.getNumericValue(s.charAt(i));
			sum += Math.pow(num, 5);
		}

		System.out.println(sum);
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B2_10988_팰린드롬인지확인하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String word = br.readLine();
		
		boolean isPal = true;
		int left = 0;
		int right = word.length()-1;
		while(left<right) {
			if(word.charAt(left) != word.charAt(right)) {
				isPal = false;
				break;
			}
			left++;
			right--;
		}
		
		System.out.println(isPal?1:0);
	}

}

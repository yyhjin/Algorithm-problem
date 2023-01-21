import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B1_1259_팰린드롬수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			String word = br.readLine();
			if(word.equals("0")) break;
			
			if(isPalindrome(word)) sb.append("yes"+"\n");
			else sb.append("no"+"\n");
		}
		
		sb.setLength(sb.length()-1);
		System.out.println(sb);

	}

	private static boolean isPalindrome(String word) {
		int left = 0;
		int right = word.length()-1;
		
		while(left < right) {
			if(word.charAt(left) != word.charAt(right)) {
				return false;
			}
			else {
				left++;
				right--;
			}
		}
		return true;
	}

}

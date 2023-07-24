import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B2_1212_8진수_2진수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String eight = br.readLine();
		for (int i = 0; i < eight.length(); i++) {
			int n = Character.getNumericValue(eight.charAt(i));
			String binary = Integer.toBinaryString(n);
			if(binary.length()==1) {
				sb.append("00").append(binary);
			}
			else if(binary.length()==2) {
				sb.append("0").append(binary);
			}
			else sb.append(binary);
		}
		
		while(sb.length()>1 && sb.charAt(0)=='0') sb.deleteCharAt(0);
		System.out.println(sb);
	}

}

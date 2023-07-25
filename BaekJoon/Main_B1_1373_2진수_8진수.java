import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B1_1373_2진수_8진수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String binary = br.readLine();
		
		while(binary.length()%3 != 0) {
			binary = "0"+binary;
		}
		
		for (int i = 0; i < binary.length()-2; i+=3) {
			int eight = (binary.charAt(i)-'0') * 4;
			eight += (binary.charAt(i+1)-'0') * 2;;
			eight += (binary.charAt(i+2)-'0') * 1;;
			
			sb.append(eight);
		}
		
		System.out.println(sb);
	}

}

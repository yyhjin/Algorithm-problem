import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_S5_7656_만능오라클 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		
		String line = "";
		boolean check = false;
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i)>='A' && str.charAt(i) <= 'Z') {
				check = true;
			}
			
			if(check) {
				if(str.charAt(i) == '.' || str.charAt(i) == '?') {
					if(str.charAt(i) == '?') {
						line += '.';
						if(line.startsWith("What is")) {
							line = "Forty-two" + line.substring(4);
							sb.append(line+"\n");
						}
					}
					check = false;
					line = "";
					continue;
				}
				line += str.charAt(i);
			}
			
		}
		
		System.out.println(sb);
	}

}

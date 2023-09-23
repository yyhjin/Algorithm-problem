import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B4_1264_모음의_개수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String line = "";
		while(!(line = br.readLine()).equals("#")) {
			int count = 0;
			for (int i = 0; i < line.length(); i++) {
				char c = line.charAt(i);
				if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u'
					|| c=='A' || c=='E' || c=='I' || c=='O' || c=='U')
					count++;
			}
			sb.append(count+"\n");
		}
		
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}

}

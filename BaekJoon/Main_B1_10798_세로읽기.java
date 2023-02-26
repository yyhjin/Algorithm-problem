import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B1_10798_세로읽기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		char[][] map = new char[5][15];
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 15; j++) {
				map[i][j] = ' ';
			}
		}
		
		for (int i = 0; i < 5; i++) {
			String s = br.readLine();
			for (int j = 0; j < s.length(); j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 5; j++) {
				if(map[j][i] == ' ') continue;
				sb.append(map[j][i]);
			}
		}
		
		System.out.println(sb);
	}

}

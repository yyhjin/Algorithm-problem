import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B3_2490_윷놀이 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < 3; i++) {
			int count = 0;
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				int status = Integer.parseInt(st.nextToken());
				if(status == 0) count++;
			}
			
			if(count==0) sb.append("E\n");
			else if(count==1) sb.append("A\n");
			else if(count==2) sb.append("B\n");
			else if(count==3) sb.append("C\n");
			else if(count==4) sb.append("D\n");
		}
		
		System.out.println(sb);
	}

}

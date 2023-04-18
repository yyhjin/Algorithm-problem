import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_B3_5073_삼각형과세변 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int[] line = new int[3];
		while(true) {
			String s = br.readLine();
			if(s.equals("0 0 0")) break;
			
			st = new StringTokenizer(s);
			line[0] = Integer.parseInt(st.nextToken());
			line[1] = Integer.parseInt(st.nextToken());
			line[2] = Integer.parseInt(st.nextToken());
			Arrays.sort(line);
			
			if(line[0]+line[1] <= line[2]) sb.append("Invalid\n");
			else if(line[0]==line[1] && line[1]==line[2]) sb.append("Equilateral\n");
			else if(line[0]==line[1] || line[1]==line[2]) sb.append("Isosceles\n");
			else sb.append("Scalene\n");
		}
		
		System.out.println(sb);
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B3_25756_방어율무시계산하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		double temp = 1;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			double cur = Integer.parseInt(st.nextToken());
			cur /= 100;	
			temp = temp * (1-cur);
			
			System.out.println(String.format("%.6f" ,(1-temp)*100));
		}

	}

}

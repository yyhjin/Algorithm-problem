import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B5_29751_삼각형 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		double W = Double.parseDouble(st.nextToken());
		double H = Double.parseDouble(st.nextToken());
		double result = W*H/2;
		
		System.out.printf("%.1f", result);
	}

}

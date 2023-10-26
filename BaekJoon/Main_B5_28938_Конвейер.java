import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B5_28938_Конвейер {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += Integer.parseInt(st.nextToken());
		}
		
		if(sum == 0) System.out.println("Stay");
		else System.out.println(sum>0?"Right":"Left");
	}

}

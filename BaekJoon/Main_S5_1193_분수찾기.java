import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_S5_1193_분수찾기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int X = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		int line = 0;
		int sum = 0;
		int prevSum = 0;
		
		for (int i = 1; i <= 10000000; i++) {
			sum += i;
			if(sum >= X) {
				line = i;
				prevSum = sum - i;
				cnt = X-prevSum;
				break;
			}
		}
		
		if(line%2==0) System.out.println(cnt+"/"+(line-cnt+1));
		else System.out.println((line-cnt+1)+"/"+cnt);

	}

}

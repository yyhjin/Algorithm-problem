import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B1_1110_더하기_사이클 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int count = 0;
		int temp = N;
		
		while(true) {
			count++;
			int a = 0;
			int b = 0;
			
			if(temp < 10) b = temp;
			else {
				a = temp/10;
				b = temp%10;
			}
						
			int sum = a+b;
			if(sum < 10) {
				temp = 0;
				if(b != 0) {
					String s = Integer.toString(b) + Integer.toString(sum);
					temp = Integer.parseInt(s);
				}
				else temp = sum;
			}
			else {
				temp = 0;
				if(b != 0) {
					String s = Integer.toString(b) + Integer.toString(sum%10);
					temp = Integer.parseInt(s);
				}
				else temp = sum%10;
			}
			
			if(N==temp) break;
		}
		
		System.out.println(count);
	}

}

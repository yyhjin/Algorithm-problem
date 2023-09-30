import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B1_11179_2진수_뒤집기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder binary = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		binary.append(Integer.toBinaryString(N));
		binary.reverse();
		int result = Integer.parseInt(binary.toString(), 2);
		
		System.out.println(result);
	}

}

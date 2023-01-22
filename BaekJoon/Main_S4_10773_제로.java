import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_S4_10773_제로 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Stack<Integer> stack = new Stack<>();
		int K = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < K; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(num == 0) stack.pop();
			else stack.push(num);
		}
		
		int size = stack.size();
		int sum = 0;
		for (int i = 0; i < size; i++) {
			sum += stack.pop();
		}
		
		System.out.println(sum);
	}

}

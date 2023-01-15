import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_S2_1874_스택수열 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		int curIdx = 0;
		int inputNum = 1;
		
		for (int i = 0; i < N*2; i++) {
			if(stack.isEmpty() || stack.peek() != nums[curIdx]) {
				stack.push(inputNum++);
				sb.append("+"+"\n");
			}
			else {
				stack.pop();
				curIdx++;
				sb.append("-"+"\n");
			}

		}
		
		if(stack.isEmpty()) {
			sb.setLength(sb.length()-1);
			System.out.println(sb);
		}
		else
			System.out.println("NO");
		
	}

}

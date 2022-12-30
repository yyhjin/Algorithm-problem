import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_9012_괄호 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<>();

		int N = Integer.parseInt(br.readLine());

		loop: 
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < line.length(); j++) {
				char cur = line.charAt(j);
				if (cur == '(')
					stack.push(cur);

				else {
					if (!stack.isEmpty())
						stack.pop();

					else {
						System.out.println("NO");
						continue loop;
					}
				}

			}
			if (stack.isEmpty())
				System.out.println("YES");
			else
				System.out.println("NO");
			stack.clear();
		}

	}

}

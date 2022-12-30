import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_17413_단어뒤집기2 {
	
	static Stack<Character> stack = new Stack<>();
	static boolean tag = false;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '<') { // 태그 처리
				stackPrint();
				tag = true;
				System.out.print(s.charAt(i));
				continue;
			}
			if (tag) {
				if (s.charAt(i) == '>')
					tag = false;
				System.out.print(s.charAt(i));
				continue;
			}

			if (s.charAt(i) == ' ') {
				stackPrint();
				System.out.print(' ');
				continue;
			}
			stack.push(s.charAt(i));

		}
		stackPrint(); //마지막에 남아있는 단어 출력

	}
	
	static void stackPrint() {
		while (stack.size() > 0)
			System.out.print(stack.pop());
	}

}

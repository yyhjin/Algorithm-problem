import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_G5_1863_스카이라인쉬운거 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		
		int count = 0;
		for (int i = 0; i <= N; i++) {
			int x, y = 0;
			
			if(i<N) {
				st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
			}
			else y = 0;
			
			// 스택보다 고도가 높으면 push만
			if(stack.isEmpty() || y>stack.peek()) stack.push(y);
			// 스택보다 고도가 낮으면 스택에서 현재보다 높은 값들을 pop해주며 건물 개수 count
			else if(y < stack.peek()){
				int size = stack.size();
				for(int j = 0; j < size; j++) {
					if(stack.peek() > y) {
						count++;
						stack.pop(); 
					}
				}
				// 스택이 비어있거나 바로 전 높이가 현재와 같지 않을 때만 push
				if(stack.isEmpty() || stack.peek() != y) 
					stack.push(y);
			}

		}
		
		System.out.println(count);
	}

}

/*
4
1 4
2 3
3 5
4 4
답 : 4

  x
x xx
xxxx
xxxx
xxxx
*/
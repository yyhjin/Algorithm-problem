import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_2493_탑 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<int[]> stack = new Stack<>(); 
		
		for (int i = 1; i <= N; i++) {
			int top = Integer.parseInt(st.nextToken().trim());

			if (stack.isEmpty()) { //스택 비어 있을 때(첫번째 값)
				System.out.print("0 ");
				stack.push(new int[] {i, top}); //{탑 번호, 탑 높이}
				continue;
			}
			while (!stack.isEmpty()) {
				if (stack.peek()[1] < top) { //스택 값이 더 작으면 앞으로 쓸 일 없기 때문에 pop
					stack.pop();
					if(stack.isEmpty()) //pop한 직후에 스택이 비어있으면
						System.out.print("0 ");
				}
				else { //스택 값이 top보다 더 큰 경우
					System.out.print(stack.peek()[0] + " ");
					break;
				}
			}
			stack.push(new int[] {i, top}); //{탑 번호, 탑 높이}
			
		}
		
	}

}

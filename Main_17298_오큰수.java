import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_17298_오큰수 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Stack<Integer> big = new Stack<>();
		Stack<Integer> answer = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = N-1; i >= 0; i--) {
			int current = num[i];
			
			// 꺼낸 수보다 현재 수가 더 클 때
			while (!big.isEmpty() && current >= big.peek())
				big.pop();
			
			// 비교 스택 비어있으면
			if (big.isEmpty()) {
				answer.push(-1);
			}
			
			// 꺼낸 수가 현재 수보다 더 클 때
			else if (big.peek() > current) {
				answer.push(big.peek());
			}
			big.push(current);

		}
		
		while(!answer.isEmpty()) {
			sb.append(answer.pop()).append(" ");
		}
		
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}

}

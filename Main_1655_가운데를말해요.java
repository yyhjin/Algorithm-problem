import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main_1655_가운데를말해요 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		// PQ의 디폴트는 최소힙이므로 최대힙은 역순 정렬
		PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> min = new PriorityQueue<>();
		
		for (int i = 0; i < N; i++) {
			int next = Integer.parseInt(br.readLine());
			
			if (max.size() == min.size()) {
				max.add(next);
				if ( !min.isEmpty() && max.peek() > min.peek()) {
					int tmp = max.poll();
					min.add(tmp);
					tmp = min.poll();
					max.add(tmp);
				}
				sb.append(max.peek()+"\n");
			}
			else if (max.size() > min.size()) {
				min.add(next);
				if (max.peek() > min.peek()) {
					int tmp = max.poll();
					min.add(tmp);
					tmp = min.poll();
					max.add(tmp);
				}
				sb.append(max.peek()+"\n");
			}
		}
		
		System.out.println(sb);
	}

}

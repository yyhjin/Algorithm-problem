import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_11279_최대힙 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			int a = Integer.parseInt(br.readLine());
			
			
			if(a==0) {
				if(pq.isEmpty())
					System.out.println(0);
				else
					System.out.println(pq.poll());
			}
			else
				pq.add(a);
		}
		
		
	}

}

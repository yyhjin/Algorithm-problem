import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_S3_14235_크리스마스_선물 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		int N = Integer.parseInt(br.readLine().trim());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int a = Integer.parseInt(st.nextToken());
			
			if(a == 0) {
				if(pq.isEmpty()) sb.append("-1\n");
				else sb.append(pq.poll()+"\n");
			}
			else {
				for (int j = 0; j < a; j++) {
					pq.add(Integer.parseInt(st.nextToken()));
				}
			}
		}

		System.out.println(sb);
	}

}

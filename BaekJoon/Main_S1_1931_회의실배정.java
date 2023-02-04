import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_S1_1931_회의실배정 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Conference> pq = new PriorityQueue<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			pq.add(new Conference(s, e));
		}
		
		int count = 0;
		int endTime = 0;
		while(!pq.isEmpty()) {
			Conference cur = pq.poll();
			
			if(cur.start >= endTime) {
				count++;
				endTime = cur.end;
			}
		}
		
		System.out.println(count);
	}

	public static class Conference implements Comparable<Conference> {
		int start;
		int end;
		
		public Conference(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Conference o) {
			if(this.end == o.end)
				return this.start-o.start;
			return this.end-o.end;
		}
	}
}

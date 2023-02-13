import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_G5_11000_강의실배정 {

	public static class Lesson implements Comparable<Lesson> {
		int start;
		int end;
		
		public Lesson(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Lesson o) {
			if(this.start == o.start)
				return this.end - o.end;
			return this.start - o.start;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());		
		ArrayList<Lesson> arr = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			arr.add(new Lesson(s, e));
		}
		
		Collections.sort(arr);
				
		PriorityQueue<Integer> endTime = new PriorityQueue<>();
		endTime.add(arr.get(0).end);
		
		for (int i = 1; i < N; i++) {
			Lesson cur = arr.get(i);
			
			if(cur.start >= endTime.peek()) {
				endTime.poll();
			}
			endTime.add(cur.end);
		}
		
		System.out.println(endTime.size());

	}

}

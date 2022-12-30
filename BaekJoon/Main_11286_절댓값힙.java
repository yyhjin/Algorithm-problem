import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main_11286_절댓값힙 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

					@Override
					public int compare(Integer o1, Integer o2) {
						int a = Math.abs(o1);
						int b = Math.abs(o2);
						if(a==b) return o1-o2;
						return a-b;
					}
		});
		
		
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

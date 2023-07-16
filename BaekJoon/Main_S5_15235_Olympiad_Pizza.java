import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_S5_15235_Olympiad_Pizza {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] result = new int[N];
		
		Deque<Integer> dq = new LinkedList<>();
		Deque<Integer> idx = new LinkedList<>();
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			idx.add(i);
			dq.add(Integer.parseInt(st.nextToken()));
		}
		
		int time = 0;
		while(!dq.isEmpty()) {
			time++;
			
			if(dq.getFirst() == 1) {
				result[idx.getFirst()] = time;
				dq.removeFirst();
				idx.removeFirst();
			}
			else {
				int temp = dq.removeFirst();
				dq.addLast(temp-1);
				temp = idx.removeFirst();
				idx.addLast(temp);
			}
		}
		
		for(int r: result) sb.append(r+" ");
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}

}

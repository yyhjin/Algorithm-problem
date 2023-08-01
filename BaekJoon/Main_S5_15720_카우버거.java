import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_S5_15720_카우버거 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int b = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Integer> burger = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> side = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> drink = new PriorityQueue<>(Collections.reverseOrder());
		
		int sum = 0;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < b; i++) {
			int price = Integer.parseInt(st.nextToken());
			burger.add(price);
			sum += price;
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < s; i++) {
			int price = Integer.parseInt(st.nextToken());
			side.add(price);
			sum += price;
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < d; i++) {
			int price = Integer.parseInt(st.nextToken());
			drink.add(price);
			sum += price;
		}
		
		int sale = 0;
		while(!burger.isEmpty() || !side.isEmpty() || !drink.isEmpty()) {
			if(!burger.isEmpty() && !side.isEmpty() && !drink.isEmpty()) {
				sale += (burger.poll()+side.poll()+drink.poll()) * 0.9;
			}
			else {
				if(!burger.isEmpty()) sale += burger.poll();
				if(!side.isEmpty()) sale += side.poll();
				if(!drink.isEmpty()) sale += drink.poll();				
			}
		}
		
		System.out.println(sum+"\n"+sale);
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main_S4_2485_가로수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		long[] map = new long[N];  // 가로수
		PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());  // 가로수 간격
		
		for (int i = 0; i < N; i++) {
			map[i] = Long.parseLong(br.readLine());
		}
		
		// 가로수 정렬 후 간격 저장
		Arrays.sort(map);
		for (int i = N-1; i >= 1 ; i--) {
			pq.add(map[i] - map[i-1]);
		}
		
		// 가로수 간격의 최대공약수 구하기
		long gcd = gcd(pq.poll(), pq.poll());
		while(!pq.isEmpty()) {
			gcd = gcd(gcd, pq.poll());
		}
		
		long count = 0;
		for (int i = N-1; i >= 1 ; i--) {
			long distance = map[i] - map[i-1];

			if(distance > gcd) {
				count += distance/gcd - 1;
			}
		}
		
		System.out.println(count);
	}

	private static long gcd(Long a, Long b) {
		while(b != 0) {
			long r = a % b;
			a = b;
			b = r;
		}
		return a;
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_S2_18870_좌표압축 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		long[] arr = new long[N];
		HashSet<Long> set = new HashSet<>();  // 중복수 제거
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			long num = Long.parseLong(st.nextToken());
			set.add(num);
			arr[i] = num;
		}
		
		// 정렬하기 위해 배열에 저장
		long[] order = new long[set.size()];
		int idx = 0;
		for (long x : set) {
			order[idx++] = x;
		}
		Arrays.sort(order);

		// 정렬된 인덱스 번호가 압축된 숫자가 됨
		HashMap<Long, Integer> map = new HashMap<>();
		for (int i = 0; i < order.length; i++) {
			map.put(order[i], i);
		}

		for (int i = 0; i < N; i++) {
			sb.append(map.get(arr[i])+" ");
		}
		
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}

}

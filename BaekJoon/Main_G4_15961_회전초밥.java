import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_G4_15961_회전초밥 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[] arr = new int[N+k-1];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());;
		}
		
		// 원형으로 만들기
		for (int i = N; i < N+k-1; i++) {
			arr[i] = arr[i-N];
		}
		
		HashMap<Integer, Integer> hash = new HashMap<>();
		for (int i = 0; i < k-1; i++) {
			hash.put(arr[i], hash.getOrDefault(arr[i], 0)+1);
		}
	
		int max = 0;
		int left = 0;
		int right = k-1;
		while(right<N+k-1 && left<=right) {
			if(max == d) break;
			
			hash.put(arr[right], hash.getOrDefault(arr[right], 0)+1);

			if(hash.containsKey(c)) max = Math.max(max, hash.size());
			else max = Math.max(max, hash.size()+1);
			
			if(hash.get(arr[left]) == 1) hash.remove(arr[left]);
			else hash.put(arr[left], hash.get(arr[left])-1);
			
			left++;
			right++;
		}
		
		System.out.println(max);
	}

}


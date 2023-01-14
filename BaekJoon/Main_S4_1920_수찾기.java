import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S4_1920_수찾기 {
	static int N;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int find = Integer.parseInt(st.nextToken());
			
			if(binarySearch(find)) {
				sb.append(1+"\n");
			}
			else
				sb.append(0+"\n");
		}
				
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}

	private static boolean binarySearch(int num) {
		int mid = -1;
		int left = 0;
		int right = N-1;
		
		while(left <= right) {
			mid = (left+right)/2;
			int value = arr[mid];
			
			if(value == num) return true;
			else if(value > num) right = mid-1;
			else left = mid+1;
		}
		return false;
	}

}

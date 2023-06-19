import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main_S5_11931_수정렬하기4 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		Integer[] arr = new Integer[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr, Collections.reverseOrder());
		for (int i = 0; i < N; i++) {
			sb.append(arr[i]+"\n");
		}
		
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}

}

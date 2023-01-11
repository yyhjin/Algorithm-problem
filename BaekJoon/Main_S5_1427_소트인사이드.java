import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main_S5_소트인사이드 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String N = br.readLine();
		
		// 밑의 내림차순 정렬을 위한 Comparator를 구현하기 위해 Integer 사용
		Integer[] arr = new Integer[N.length()]; 
		
		for (int i = 0; i < N.length(); i++) {
			char c = N.charAt(i);
			arr[i] = Character.getNumericValue(c);
		}

		Arrays.sort(arr, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		});
		
		/* 위의 내림차순 코드와 같음
		Arrays.sort(arr, (o1, o2) -> o2 - o1);
		*/
		
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i]);
		}
		
		System.out.println(sb);
	}

}

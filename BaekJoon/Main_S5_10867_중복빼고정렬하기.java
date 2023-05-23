import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_S5_10867_중복빼고정렬하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		HashMap<Integer, Integer> hash = new HashMap<>();
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			hash.put(Integer.parseInt(st.nextToken()), 1);
		}
		
		ArrayList<Integer> arr = new ArrayList<>();
		for(int key : hash.keySet()) {
			arr.add(key);
		}
		
		Collections.sort(arr);
		for (int i = 0; i < arr.size(); i++) {
			sb.append(arr.get(i)+" ");
		}
		
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}

}

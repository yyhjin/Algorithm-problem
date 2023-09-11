import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_S4_1822_차집합 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int nA = Integer.parseInt(st.nextToken());
		int nB = Integer.parseInt(st.nextToken());
		ArrayList<Integer> result = new ArrayList<>();
		
		Set<Integer> A = new HashSet<>();
		Set<Integer> B = new HashSet<>();
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < nA; i++) {
			A.add(Integer.parseInt(st.nextToken()));
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < nB; i++) {
			B.add(Integer.parseInt(st.nextToken()));
		}
		
		for(int num: B) {
			A.remove(num);
		}
		for(int num: A) {
			result.add(num);
		}
		
		Collections.sort(result);
		for(int num: result) {
			sb.append(num+" ");
		}
		
		if(result.size() > 0) {
			System.out.println(result.size());
			sb.setLength(sb.length()-1);
			System.out.println(sb);
		}
		else System.out.println(0);
	}

}

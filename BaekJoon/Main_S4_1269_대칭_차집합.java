import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_S4_1269_대칭_차집합 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int cntA = Integer.parseInt(st.nextToken());
		int cntB = Integer.parseInt(st.nextToken());
		
		Set<Integer> A = new HashSet<>();
		Set<Integer> B = new HashSet<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < cntA; i++) {
			A.add(Integer.parseInt(st.nextToken()));
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < cntB; i++) {
			B.add(Integer.parseInt(st.nextToken()));
		}
		
		Set<Integer> cha = new HashSet<>();
		
		for(int n: A) {
			if(!B.contains(n)) cha.add(n);
		}
		for(int n: B) {
			if(!A.contains(n)) cha.add(n);
		}
		
		System.out.println(cha.size());
	}

}

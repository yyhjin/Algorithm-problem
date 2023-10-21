import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_S4_15233_Final_Score {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int aCnt = Integer.parseInt(st.nextToken());
		int bCnt = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		
		Set<String> A = new HashSet<>();
		Set<String> B = new HashSet<>();
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < aCnt; i++) {
			A.add(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < bCnt; i++) {
			B.add(st.nextToken());
		}
		
		int aScore = 0;
		int bScore = 0;
		st = new StringTokenizer(br.readLine());		
		for (int i = 0; i < G; i++) {
			String name = st.nextToken();
			if(A.contains(name)) aScore++;
			else if(B.contains(name)) bScore++;
		}
		
		if(aScore == bScore) System.out.println("TIE");
		else System.out.println(aScore>bScore?"A":"B");
	}

}

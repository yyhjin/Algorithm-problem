import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Main_S4_16499_동일한_단어_그룹화하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		HashSet<String> set = new HashSet<>();
		
		for (int i = 0; i < N; i++) {
			char[] word = br.readLine().toCharArray();
			Arrays.sort(word);
			set.add(Arrays.toString(word));
		}
		
		System.out.println(set.size());
	}

}

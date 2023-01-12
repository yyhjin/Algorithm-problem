import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main_S3_11478_서로다른부분문자열의개수 {
	
	static String s;
	static Set<String> set = new HashSet<>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		s = br.readLine();
				
		for (int i = 1; i <= s.length(); i++) {
			find(i);			
		}
		
		System.out.println(set.size());

	}

	private static void find(int cnt) {
		
		for (int i = 0; i < s.length()-cnt+1; i++) {
			sb.setLength(0);
			
			for (int j = i; j < i+cnt; j++) {
				sb.append(s.charAt(j));
			}
			
			if(sb.length() > 0)
				set.add(sb.toString());
		}
	}


}

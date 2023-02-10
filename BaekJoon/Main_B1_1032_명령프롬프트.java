import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_B1_1032_명령프롬프트 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<String> arr = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			arr.add(s);
		}
		
		boolean[] diff = new boolean[arr.get(0).length()]; 
		for (int i = 1; i < arr.size(); i++) {
			String prev = arr.get(i-1);
			String cur = arr.get(i);
			
			for (int j = 0; j < cur.length(); j++) {
				if(prev.charAt(j) != cur.charAt(j))
					diff[j] = true;
			}
		}
		
		String base = arr.get(0);
		for (int i = 0; i < diff.length; i++) {
			if(diff[i]) sb.append("?");
			else sb.append(base.charAt(i));
		}
		
		System.out.println(sb);
	}

}

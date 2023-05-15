import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_S4_1543_문서검색 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String document = br.readLine();
		String word = br.readLine();
		
		ArrayList<Integer> idx = new ArrayList<>();
		for(int i = 0; i < document.length()-word.length()+1; i++) {
			String sub = document.substring(i, i+word.length());
			if(sub.equals(word)) {
				idx.add(i);
			}
		}
		
		int max = 0;
		for (int i = 0; i < idx.size(); i++) {
			int cnt = 1;
			int prev = idx.get(i);
			for (int j = i+1; j < idx.size(); j++) {
				if(idx.get(j)-prev >= word.length()) {
					prev = idx.get(j);
					cnt++;
				}
			}
			max = Math.max(max, cnt);
		}

		System.out.println(max);
	}

}

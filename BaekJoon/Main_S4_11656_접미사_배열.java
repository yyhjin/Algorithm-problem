import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main_S4_11656_접미사_배열 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String word = br.readLine();
		List<String> list = new ArrayList<>();
		
		for (int i = 0; i < word.length(); i++) {
			list.add(word.substring(i));
		}
		
		Collections.sort(list);
		for(String s : list) {
			sb.append(s+"\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}

}

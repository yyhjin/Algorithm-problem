import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main_S5_1181_단어정렬 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<String> arr = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			if(!arr.contains(line)) {
                arr.add(line);    
            };
		}
		
		Collections.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if(o1.length() == o2.length())
					return o1.compareTo(o2);
				return o1.length()-o2.length();
			}
		});

		for (int i = 0; i < arr.size(); i++) {
			sb.append(arr.get(i)+"\n");
		}
		
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}

}

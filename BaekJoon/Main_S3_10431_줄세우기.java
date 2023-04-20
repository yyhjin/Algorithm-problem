import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_S3_10431_줄세우기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int P = Integer.parseInt(br.readLine());
		for (int t = 1; t <= P; t++) {
			st = new StringTokenizer(br.readLine());
			sb.append(st.nextToken()+" ");
			
			LinkedList<Integer> list = new LinkedList<>();
			int count = 0;
			for (int i = 0; i < 20; i++) {
				int cur = Integer.parseInt(st.nextToken());
				
				int maxIdx = i;
				for (int j = list.size()-1; j >= 0; j--) {
					if(list.get(j) > cur) {
						maxIdx = j;
					}
				}
				
				// 앞에 큰 학생이 있을 경우
				if(maxIdx != i) {
					count += (i-maxIdx);
					list.add(maxIdx, cur);
				}
				else list.add(cur);
			}
			
			sb.append(count+"\n");
		}
		
		System.out.println(sb);
	}

}

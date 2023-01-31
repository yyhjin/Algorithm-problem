import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_G5_5430_AC {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			String p = br.readLine();
			int n = Integer.parseInt(br.readLine());
			String arr = br.readLine();
			arr = arr.substring(1, arr.length()-1);  // 괄호 제거
			st = new StringTokenizer(arr);

			Deque<String> dq = new LinkedList<>();

			boolean reverse = false;
			boolean error = false;
			for (int i = 0; i < n; i++) {
				String s = st.nextToken(",");
				dq.add(s);
			}
			
			for (int i = 0; i < p.length(); i++) {
				if(p.charAt(i) == 'R') {
					reverse = !reverse;
				}
				else if(p.charAt(i) == 'D') {
					if(dq.size() == 0) {
						sb.setLength(0);
						sb.append("error");
						error = true;
						break;
					}
				
					if(!reverse) {
						dq.removeFirst();
					}
					else {
						dq.removeLast();
					}
				}
			}
			
			int size = dq.size();
			if(error)
				System.out.println(sb);
			else {
				sb.append("[");
				for (int i = 0; i < size; i++) {
					if(!reverse) {
						sb.append(dq.pollFirst()+",");
					}
					else {
						sb.append(dq.pollLast()+",");
					}
				}
				
				if(sb.length()>1)
					sb.setLength(sb.length()-1);
				sb.append("]");
				System.out.println(sb);	
			}
			
			sb.setLength(0);
		}

	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main_G5_7662_이중우선순위큐 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
//		PriorityQueue<Integer> min = new PriorityQueue<>();
//		PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
		TreeMap<Integer, Integer> tree = new TreeMap<>();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int k = Integer.parseInt(br.readLine());
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				
				String order = st.nextToken();
				int num = Integer.parseInt(st.nextToken());
				
				if(order.equals("I")) {
					tree.put(num, tree.getOrDefault(num, 0)+1);
				}
				else if(order.equals("D")) {
					if(tree.isEmpty()) continue;
					
					if(num == 1) {
						int del = tree.lastKey();
						if(tree.get(del) == 1)
							tree.remove(del);
						else
							tree.replace(del, tree.get(del)-1);
					}
					else {
						int del = tree.firstKey();
						if(tree.get(del) == 1)
							tree.remove(del);
						else
							tree.replace(del, tree.get(del)-1);
					}
				}
			}

			if(tree.isEmpty())
				sb.append("EMPTY"+"\n");
			else
				sb.append(tree.lastKey()+" "+tree.firstKey()+"\n");
		
			tree.clear();
		}
		
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}

}

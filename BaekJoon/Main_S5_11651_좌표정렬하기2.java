import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_S5_11651_좌표정렬하기2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<Dot> arr = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			arr.add(new Dot(x, y));
		}
		
		arr.sort(new Comparator<Dot>() {
			@Override
			public int compare(Dot o1, Dot o2) {
				if(o1.y == o2.y)
					return o1.x - o2.x;
				return o1.y - o2.y;
			}
		});
		
		for (int i = 0; i < N; i++) {
			Dot cur = arr.get(i);
			sb.append(cur.x+" "+cur.y+"\n");
		}
		
		sb.setLength(sb.length()-1);
		System.out.println(sb);

	}
	
	public static class Dot {
		int x;
		int y;
		
		public Dot(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}

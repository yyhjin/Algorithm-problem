import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_S5_8979_올림픽 {

	public static class Score implements Comparable<Score> {
		int name;
		int gold;
		int silver;
		int bronze;
		int rank;
		
		public Score(int name, int gold, int silver, int bronze) {
			this.name = name;
			this.gold = gold;
			this.silver = silver;
			this.bronze = bronze;
		}

		@Override
		public int compareTo(Score o) {
			if(o.gold != this.gold)
				return o.gold - this.gold;
			else if(o.silver != this.silver)
				return o.silver - this.silver;
			else
				return o.bronze - this.bronze;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		List<Score> list = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.add(new Score(n, g, s, b));
		}
		
		Collections.sort(list);
		
		int answerIdx = 0;
		
		list.get(0).rank = 1;
		Score prev = list.get(0);
		for(int i = 1; i < N; i++) {
			Score cur = list.get(i);
			
			if(cur.gold == prev.gold && cur.silver == prev.silver && cur.bronze == prev.bronze) {
				cur.rank = prev.rank;
			}
			else {
				cur.rank = i+1;
			}
			
			if(cur.name == K) {
				answerIdx = i;
				break;
			}
			prev = cur;
		}
		
		System.out.println(list.get(answerIdx).rank);
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G4_1963_소수경로 {
	static int a, b;
	static boolean[] prime = new boolean[10000];
	static boolean[] v;
	static int[] count;
	static boolean possible;
			
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		// 에라토스테네스의 체
		Arrays.fill(prime, true);
		for (int i = 2; i < 10000; i++) {
			if(!prime[i]) continue;
			
			for (int j = i+i; j < 10000; j+=i) {
				prime[j] = false;
			}
		}
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			possible = false;
			v = new boolean[10000];
			count = new int[10000];
			
			if(a == b)
				sb.append(0+"\n");
			else {
				bfs();
				if(count[b] == 0) {
					sb.append("Impossible"+"\n");
				}
				else sb.append(count[b]+"\n");
				
			}
		}
		
		sb.setLength(sb.length()-1);
		System.out.println(sb);

	}

	private static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(a);
		v[a] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j <= 9; j++) {
					if((i==0 && j==0) ) continue;

					int change = change(cur, i, j);
					
					if(prime[change] && !v[change]) {
						v[change] = true;
						count[change] = count[cur]+1;
						q.add(change);
					}
				}
			}
		}
		
	}

	private static int change(int num, int position, int change) {
		int[] n = new int[4];
		String s = Integer.toString(num);
		n[0] = Character.getNumericValue(s.charAt(0));
		n[1] = Character.getNumericValue(s.charAt(1));
		n[2] = Character.getNumericValue(s.charAt(2));
		n[3] = Character.getNumericValue(s.charAt(3));
		n[position] = change;

		s = "";
		for (int i = 0; i < 4; i++) {
			s += n[i];
		}
		
		return Integer.parseInt(s);
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_S4_20125_쿠키의신체측정 {
	
	static int N;
	static char[][] map;
	static int hr, hc;  // 심장 위치
	static int wr, wc;  // 허리 위치
	static int[] dr = { -1, 1, 0, 0 };  // 상하좌우
	static int[] dc = { 0, 0, -1, 1 };
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new char[N+1][N+1];
		
		for (int i = 1; i <= N; i++) {
			String line = br.readLine();
			for (int j = 1; j <= N; j++) {
				map[i][j] = line.charAt(j-1);
			}
		}
		
		heart();  // 심장 좌표 찾기
		sb.append(hr+" "+hc+"\n");
		leftArm();
		rightArm();
		waist();
		leftLeg();
		rightLeg();
		
		System.out.println(sb);
	}

	private static void leftArm() {
		int count = 0;
		int r = hr;
		int c = hc;
		while(true) {
			int nr = r + dr[2];
			int nc = c + dc[2];
			
			if(!check(nr, nc)) break;
			
			count++;
			r = nr;
			c = nc;
		}
		sb.append(count+" ");
	}

	private static void rightArm() {
		int count = 0;
		int r = hr;
		int c = hc;
		while(true) {
			int nr = r + dr[3];
			int nc = c + dc[3];
			
			if(!check(nr, nc)) break;
			
			count++;
			r = nr;
			c = nc;
		}
		sb.append(count+" ");
	}

	private static void waist() {
		int count = 0;
		int r = hr;
		int c = hc;
		while(true) {
			int nr = r + dr[1];
			int nc = c + dc[1];
			
			if(!check(nr, nc)) break;
			
			count++;
			r = nr;
			c = nc;
			wr = r;
			wc = c;
		}
		sb.append(count+" ");
	}
	
	private static void leftLeg() {
		int count = 1;
		int r = wr+1;
		int c = wc-1;
		while(true) {
			int nr = r + dr[1];
			int nc = c + dc[1];
			
			if(!check(nr, nc)) break;
			
			count++;
			r = nr;
			c = nc;
		}
		sb.append(count+" ");
	}
	
	private static void rightLeg() {
		int count = 1;
		int r = wr+1;
		int c = wc+1;
		while(true) {
			int nr = r + dr[1];
			int nc = c + dc[1];
			
			if(!check(nr, nc)) break;
			
			count++;
			r = nr;
			c = nc;
		}
		sb.append(count);
	}

	private static void heart() {
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				boolean isHeart = true;
				
				for(int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					
					if(!check(nr, nc)) {
						isHeart = false;
						break;
					}
				}
				if(isHeart) {
					hr = r;
					hc = c;
					return;
				}
			}
		}
	}
	
	private static boolean check(int r, int c) {
		if(!(r>0 && c>0 && r<=N && c<=N) || map[r][c]=='_') return false;
		return true;
	}

}

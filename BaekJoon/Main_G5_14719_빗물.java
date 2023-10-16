import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G5_14719_빗물 {

	static int H, W;
	static int[][] map;
	static int count;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < W; i++) {
			int depth = Integer.parseInt(st.nextToken());
			for (int j = H-1; j > H-1-depth; j--) {
				map[j][i] = 1;
			}
		}
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if(map[i][j] == 0) {
					check(i, j);
				}
			}
		}
		
		System.out.println(count);
	}

	private static void check(int r, int c) {
		int wall = 0;
		//  좌
		while(true) {
			int nr = r;
			int nc = c-1;
			
			if(!(nr>=0 && nc>=0 && nr<H && nc<W)) break;
			if(map[nr][nc] == 1) {
				wall++;
				break;
			}
			r = nr;
			c = nc;
		}
		
		// 우
		while(true) {
			int nr = r;
			int nc = c+1;
			
			if(!(nr>=0 && nc>=0 && nr<H && nc<W)) break;			
			if(map[nr][nc] == 1) {
				wall++;
				break;
			}
			r = nr;
			c = nc;
		}
		
		if(wall == 2) count++;
	}

}
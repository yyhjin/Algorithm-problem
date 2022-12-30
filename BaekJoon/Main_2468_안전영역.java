import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2468_안전영역 {

	static int N ;
	static boolean[][] v;
    static int[][] map;
    static int count;
    static ArrayList<Integer> list = new ArrayList<>();
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        
        for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(!list.contains(map[i][j])) list.add(map[i][j]);
			}
		}
        
        for (int depth: list) {
        	v = new boolean[N][N];
        	int cnt = 0;
        	
        	for (int i = 0; i < N; i++) {
    			for (int j = 0; j < N; j++) {
    				if(map[i][j]<=depth)
    					v[i][j] = true;
    			}
    		}
        	
    		for (int i = 0; i < N; i++) {
    			for (int j = 0; j < N; j++) {
    				if(map[i][j] > depth && !v[i][j]) {
    					bfs(i, j);
    					cnt++;
    				}
    			}
    		}
    		
    		count = Math.max(count, cnt);
		}
        
		if (count == 0) count = 1;
        System.out.println(count);
        
	}


	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	private static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		
		q.add(new int[] {r, c});
		v[r][c] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int cr = cur[0];
			int cc = cur[1];
			
			for (int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				if(!(nr>=0 && nc>=0 && nr<N && nc<N) || v[nr][nc])
					continue;
				
				q.add(new int[] {nr, nc});
				v[nr][nc] = true;
			}
		}
	}

	

}

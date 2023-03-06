import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_S2_1058_친구 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] friends = new int[N+1][N+1];
		int[][] answer = new int[N+1][N+1];
		
		for (int i = 1; i <= N; i++) {
			String line = br.readLine();
			for (int j = 1; j <= N; j++) {
				char f = line.charAt(j-1);
				if(f=='Y') {
					friends[i][j] = 1;
					answer[i][j] = 1;
				}
			}
		}
		
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if(i==k || i==j) continue;
					if((friends[i][k]==1 && friends[k][j]==1))
						answer[i][j] = 1;
							
				}
			}
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(answer[i][j] == 1)
					answer[i][0]++;
			}
		}

		int max = 0;
		for (int i = 1; i <= N; i++) {
			max = Math.max(max, answer[i][0]);
		}
		
		System.out.println(max);
	}

}

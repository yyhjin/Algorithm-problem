import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S5_7568_덩치 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][3];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int weight = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			
			arr[i][0] = weight;
			arr[i][1] = height;
			arr[i][2] = 1;
		}
		
		for (int i = 0; i < N; i++) {
			int curW = arr[i][0];
			int curH = arr[i][1];
			
			for (int j = 0; j < N; j++) {
				if(i == j) continue;
				
				if(arr[j][0]>curW && arr[j][1]>curH) {
					arr[i][2]++;
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			sb.append(arr[i][2]+" ");
		}

		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}

}

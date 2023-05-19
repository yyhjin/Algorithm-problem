import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B1_4344_평균은넘겠지 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int C = Integer.parseInt(br.readLine());
		for (int t = 0; t < C; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[] score = new int[N];
			
			float avg = 0;
			for (int i = 0; i < N; i++) {
				score[i] = Integer.parseInt(st.nextToken());
				avg += score[i];
			}
			avg /= N;
			
			float count = 0;
			for (int i = 0; i < N; i++) {
				if(score[i] > avg) count++;
			}
			sb.append(String.format("%.3f", count/N*100)+"%\n");
		}
		
		System.out.println(sb);
	}

}

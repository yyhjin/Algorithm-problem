import java.util.Scanner;

public class Main_11729_하노이탑이동순서 {
	
	static int N, cnt;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		
		N = scann.nextInt();
		
		hanoi(N, 1, 2, 3);
		System.out.println(cnt);
		System.out.println(sb);
	}

	public static void hanoi(int N, int from, int tmp, int to) {
				
		if (N==0) {
			return ;
		}
		
		else {
			cnt++;
			
			// n-1개 탑을 tmp로
			hanoi(N-1, from, to, tmp);
			
			// 마지막 남은 1개를 목적지로
			sb.append(from+" "+to+"\n");
			
			// tmp에 있던 탑들을 목적지로
			hanoi(N-1, tmp, from, to);
		}
	}

}

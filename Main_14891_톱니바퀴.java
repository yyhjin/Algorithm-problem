

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_14891_톱니바퀴 {

	static int K;
	static int[][] rotate;
	static LinkedList<LinkedList> magnet;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		magnet = new LinkedList<>();
		magnet.add(null);

		// 자석 정보
		for (int i = 1; i < 4 + 1; i++) { // 0번은 안씀
			String line = br.readLine();
			LinkedList<Integer> list = new LinkedList<>();
			for (int j = 0; j < 8; j++) {
				list.add(Character.getNumericValue(line.charAt(j)));
			}
			magnet.add(list);
		}

		K = Integer.parseInt(br.readLine());
		rotate = new int[K][2];
		
		// 회전 정보
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int direction = Integer.parseInt(st.nextToken());
			rotate[i][0] = num;
			rotate[i][1] = direction;
		}
		
		// 회전
		for (int i = 0; i < K; i++) {
			int num = rotate[i][0];
			int direction = rotate[i][1];
			rotation(num, direction);
		}

		int score = 0;

		for (int i = 1, j = 1; i < 5; i++, j *= 2) {
			if ((int) magnet.get(i).get(0) == 1)
				score += j;
		}
		System.out.println(score);

	}

	private static void rotation(int num, int direction) {
		boolean[] check = new boolean[4];
		
		for (int i = 1; i < 4; i++) {
			if (magnet.get(i).get(2)==magnet.get(i+1).get(6)) check[i] = true;
			else check[i] = false;
		}
		
		// 시계 방향
		if (direction==1) {
			turn(num);

			for (int i = num; i < 4; i++) {
				// 겹친 부분이 같으면
				if (check[i]) {
					break;
				}
				else {
					int target = (num+2)%4;
					if (target == 0) target = 4;
					if (i+1 == target)
						turn(i+1);
					else
						reverse(i+1);
				}
			}
			
			for (int i = num; i > 1; i--) {
				if (check[i-1]) {
					break;
				}
				else {
					int target = (num+2)%4;
					if (target == 0) target = 4;
					if (i-1 == target)
						turn(i-1);
					else
						reverse(i-1);
				}
			}
		}
		
		// 반시계 방향
		else if (direction==-1) {
			reverse(num);
			
			for (int i = num; i < 4; i++) {
				// 겹친 부분이 같으면
				if (check[i]) {
					break;
				}
				else {
					int target = (num+2)%4;
					if (target == 0) target = 4;
					if (i+1 == target)
						reverse(i+1);
					else
						turn(i+1);
				}
			}
			
			for (int i = num; i > 1; i--) {
				if (check[i-1]) {
					break;
				}
				else {
					int target = (num+2)%4;
					if (target == 0) target = 4;
					if (i-1 == target) 
						reverse(i-1);
					else
						turn(i-1);
				}
			}
		}
		
	}

	private static void reverse(int i) {
		int start = (int) magnet.get(i).get(0);
		magnet.get(i).remove(0);
		magnet.get(i).add(start);
		
	}

	private static void turn(int i) {
		int end = (int) magnet.get(i).get(7);
		magnet.get(i).remove(7);
		magnet.get(i).add(0, end);
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S1_1074_Z {

	static int r, c, count;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		int a = (int) Math.pow(2, N);
		find(a, 0, 0);
		System.out.println(count);
	}

	private static void find(int size, int x, int y) {
		if (size == 1) return;

		if (x + (size / 2) > r && y + (size / 2) > c)
			find(size / 2, x, y);
		else if (x + (size / 2) > r && y + (size / 2) <= c) {
			count += (size * size) / 4;
			find(size / 2, x, y + (size / 2));
		} 
		else if (x + (size / 2) <= r && y + (size / 2) > c) {
			count += ((size * size) / 4) * 2;
			find(size / 2, x + (size / 2), y);
		} 
		else if (x + (size / 2) <= r && y + (size / 2) <= c) {
			count += ((size * size) / 4) * 3;
			find(size / 2, x + (size / 2), y + (size / 2));
		}
	}

}

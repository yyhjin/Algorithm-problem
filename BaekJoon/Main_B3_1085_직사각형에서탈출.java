import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B3_1085_직사각형에서탈출 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		int min = Integer.MAX_VALUE;
		
		if(x < w) min = Math.min(min, h-y);		
		if(y < h) min = Math.min(min, w-x);
		min = Math.min(min, y);
		min = Math.min(min, x);
		
		System.out.println(min);
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_B3_4153_직각삼각형 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			
			int[] tri = new int[3];
			tri[0] = Integer.parseInt(st.nextToken());
			tri[1] = Integer.parseInt(st.nextToken());
			tri[2] = Integer.parseInt(st.nextToken());
			
			if(tri[0]==0 && tri[1]==0 && tri[2]==0) break;

			Arrays.sort(tri);
			
			if(Math.pow(tri[0], 2) + Math.pow(tri[1], 2) == Math.pow(tri[2], 2))
				sb.append("right"+"\n");
			else sb.append("wrong"+"\n");
		}
		
		sb.setLength(sb.length()-1);
		System.out.println(sb);

	}

}

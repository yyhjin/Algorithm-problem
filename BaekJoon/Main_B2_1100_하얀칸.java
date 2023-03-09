import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B2_1100_하얀칸 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int count = 0;
		boolean isWhite = false;
		for (int i = 0; i < 8; i++) {
			String line = br.readLine();
			
			if(i%2==0) isWhite = true;
			else isWhite = false;
			for (int j = 0; j < 8; j++) {
				if(line.charAt(j)=='F' && isWhite) count++;
				isWhite = !isWhite;
			}
		}
		
		System.out.println(count);
	}

}

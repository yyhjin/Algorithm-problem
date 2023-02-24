import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_S4_1065_한수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int count = 0;
		
		int num = 1;
		while(num <= N) {
			if(isHan(num)) count++;
			num++;
		}
		
		System.out.println(count);
	}

	private static boolean isHan(int n) {
		if(n<100) return true;
		
		String s = Integer.toString(n);
		int gap = Character.getNumericValue(s.charAt(1)) 
				- Character.getNumericValue(s.charAt(0));
		for (int i = 2; i < s.length(); i++) {
			int g = Character.getNumericValue(s.charAt(i)) 
					- Character.getNumericValue(s.charAt(i-1));
			if(gap != g) return false;
		}
	
		return true;
	}

}

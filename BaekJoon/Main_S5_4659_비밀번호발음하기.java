import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_S5_4659_비밀번호발음하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String pwd = "";
		while(!(pwd = br.readLine()).equals("end")) {
			if(isGood(pwd)) sb.append("<"+pwd+"> is acceptable.\n");
			else sb.append("<"+pwd+"> is not acceptable.\n");
		}

		System.out.println(sb);
	}

	private static boolean isGood(String str) {
		if(!(str.contains("a") || str.contains("e") || str.contains("i")
				|| str.contains("o") || str.contains("u"))) return false;
		
		int mCount = 0;
		int jCount = 0;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u') {
				mCount++;
				jCount = 0;
			}
			else {
				jCount++;
				mCount = 0;
			}
			
			if(mCount == 3 || jCount == 3) return false;
			if(i >= 1 && str.charAt(i-1)==c && c != 'e' && c != 'o') return false;
		}
		
		return true;
	}

}

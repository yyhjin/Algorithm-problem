import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_G4_2661_좋은수열 {

	static int N;
	static String good = "";
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		make("");		
	}

	private static void make(String str) {
		if(str.length() == N) {
			System.out.println(str);
			System.exit(0);  // 맨 처음 값만 출력하고 재귀 종료시킴
		}
		else {
			for (int i = 1; i <= 3; i++) {
				if(isGood(str+i))
					make(str+i);
			}
		}
	}

	private static boolean isGood(String str) {
		boolean result = true;
		
		loop:
		for (int i = 0; i < str.length(); i++) {
			for (int j = i+1; j < str.length(); j++) {
				if(str.charAt(i) == str.charAt(j)) {
					int gap = j - i;
					
					// 좋은수열 여부
					boolean check = false;
					for (int k = 0; k < gap; k++) {
						if(i+k < str.length() && j+k < str.length()) {
							if(str.charAt(i+k) != str.charAt(j+k)) {
								check = true;
							}
						}
						// 길이 안맞을 때
						else check = true;
					}
					
					if(!check) {
						result = false;
						break loop;
					}
				}
			}
		}
		return result;
	}

}

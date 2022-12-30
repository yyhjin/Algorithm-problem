import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;


public class Algo1_서울_15반_윤혜진 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		HashMap<String, String> map = new HashMap<>();
		String[] words = new String[N-M+1];
		
		int idx = 0;
		for (int i = M; i <= N; i++) {
			// 숫자 자리수 하나하나 체크하기 위해 String으로 받음
			String a = String.valueOf(i);
			String eng = "";

			// 숫자를 영어 단위로 변환
			for (int k = 0; k < a.length(); k++) {
				eng += change(a.charAt(k));
			}
			// 변환한 영어 단어를 key로, 원래 숫자를 value로 map에 저장
			map.put(eng, a);
			// 영어 단어 기준으로 정렬하기 위해 String 배열에 영어 단어만 저장
			words[idx] = eng;
			idx++;
		}
		
		// 영어 단어 사전 순으로 정렬
		Arrays.sort(words);
		
		// 정렬한 순서에 맞춰 value값(숫자) 빼옴
		for (int i = 1; i <= map.size(); i++) {
			sb.append(map.get(words[i-1])+" ");
			
			// 한줄에 10개 출력했으면 개행
			if (i%10==0) {
				sb.setLength(sb.length()-1); // 줄의 맨 뒤 공백 제거
				sb.append("\n");
			}
		}
		
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}

	private static String change(char n) {
		if (n=='1')
			return "one";
		else if (n=='2')
			return "two";
		else if (n=='3')
			return "three";
		else if (n=='4')
			return "four";
		else if (n=='5')
			return "five";
		else if (n=='6')
			return "six";
		else if (n=='7')
			return "seven";
		else if (n=='8')
			return "eight";
		else if (n=='9')
			return "nine";
		else if (n=='0')
			return "zero";
		
		return "none";
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Main_S3_2108_통계학 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		HashMap<Integer, Integer> map = new HashMap<>();
		ArrayList<Integer> arr = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			map.put(num, map.getOrDefault(num, 0)+1);
			arr.add(num);
		}
		
		int maxFreq = 0;
		ArrayList<Integer> freq = new ArrayList<>();
		for(int num : map.keySet()) {			
			int value = map.get(num);
			if(maxFreq < value) {
				maxFreq = value;
				freq.clear();
				freq.add(num);
			}
			else if(maxFreq == value) {
				freq.add(num);
			}
		}
		
		Collections.sort(arr);
		Collections.sort(freq);
		
		double avg = 0;
		for (int i = 0; i < N; i++) {
			avg += arr.get(i);
		}
		avg /= N;
		
		//산술평균
		String a = String.format("%.0f\n", avg);
		if(a.equals("-0\n")) sb.append("0\n");
		else sb.append(String.format("%.0f\n", avg));
		//중앙값
		sb.append(arr.get(N/2)+"\n");
		// 최빈값
		if(freq.size()>=2)
			sb.append(freq.get(1)+"\n");
		else
			sb.append(freq.get(0)+"\n");
		//범위
		if(N == 1)
			sb.append("0\n");
		else
			sb.append(Math.abs(arr.get(0)-arr.get(N-1)));
		
		System.out.println(sb);
	}

}

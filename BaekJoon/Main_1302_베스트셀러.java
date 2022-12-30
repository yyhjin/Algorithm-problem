import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main_1302_베스트셀러 {

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		
		int N = scann.nextInt();
		Map<String, Integer> map = new HashMap<>();
		
		for (int i = 0; i < N; i++) {
			String book = scann.next();
			map.put(book, map.getOrDefault(book, 0)+1);
		}
		
		ArrayList<String> books = new ArrayList<>();
		int max = 0;
		for (String key : map.keySet()) {
			max = Math.max(max, map.get(key));
		}
		
		for (String key : map.keySet()) {
			if(map.get(key) == max)
				books.add(key);
		}
		
		Collections.sort(books);
		System.out.println(books.get(0));
	}

}

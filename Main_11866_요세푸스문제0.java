import java.util.LinkedList;
import java.util.Scanner;

public class Main_11866_요세푸스문제0 {

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		
		int N = scann.nextInt();
		int K = scann.nextInt();
		
		LinkedList<Integer> q = new LinkedList<>();
		
		for (int i = 1; i <= N; i++) {
			q.add(i);
		}
		
		int k = 0;
		while (!q.isEmpty()) {
			k = k + (K-1);
			if (k > q.size()-1)
				k = k%q.size();

			int a = q.get(k);
			sb.append(a)
				.append(", ");
			q.remove(k);
		}
		
		sb.setLength(sb.length()-2);
		sb.append(">");
		System.out.println(sb);
	}

}

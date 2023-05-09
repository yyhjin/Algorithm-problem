import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_S3_20920_영단어암기는괴로워 {

	public static class Word implements Comparable<Word> {
		String name;
		int freq;
		
		public Word(String word, int freq) {
			this.name = word;
			this.freq = freq;
		}
		
		public int compareTo(Word o) {
			if(o.freq != this.freq)
				return o.freq - this.freq;
			
			if(o.name.length() != this.name.length())		
				return o.name.length() - this.name.length();

			return this.name.compareTo(o.name);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		PriorityQueue<Word> pq = new PriorityQueue<Word>();
		HashMap<String, Integer> hash = new HashMap<>();
		
		for (int i = 0; i < N; i++) {
			String word = br.readLine();
			if(word.length() < M) continue;
			hash.put(word, hash.getOrDefault(word, 0)+1);
		}
		
		for(String w : hash.keySet()) {
			int cnt = hash.get(w);
			pq.add(new Word(w, cnt));
		}
		
		while(!pq.isEmpty()) {
			Word w = pq.poll();
			sb.append(w.name+"\n");
		}
		System.out.println(sb);
	}

}

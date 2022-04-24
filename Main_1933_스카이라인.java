package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main_1933_스카이라인 {

	static class B {
		int x,h;
		B(int x, int h) {
			this.x=x;
			this.h=h;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 우선순위 큐 : x좌표 오름차순
		PriorityQueue<B> pq  = new PriorityQueue<>(new Comparator<B>() {
			@Override
			public int compare(B o1, B o2) {
				if (o1.x == o2.x) 
					return o2.h-o1.h;
				return o1.x-o2.x;
			}
		});
		
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			pq.offer(new B(L, H));
			pq.offer(new B(R, -H));
		}
		
		// 트리맵 : 높이 내림차순
		TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
		
		int maxX = 0;
		int pmaxH = 0;

		while(!pq.isEmpty()) {
			B cur = pq.poll();
			
			if (cur.h > 0)  //시작하는 점
				map.put(cur.h, map.getOrDefault(cur.h, 0)+1);
			else {  //끝나는 점
				int value = map.get(-cur.h);
				if (value == 1)
					map.remove(-cur.h);
				else
					map.replace(-cur.h, value-1);
			}
			
			int cmaxH;
			
			if (map.isEmpty())
				cmaxH = 0;
			else
				cmaxH = map.firstKey();
			
			if (pmaxH != cmaxH && maxX != cur.x) {
				pmaxH = cmaxH;
				maxX = cur.x;
				System.out.print(maxX+" "+cmaxH+" ");
			}
			
		}
	}
}

package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_2606_바이러스 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int comN = Integer.parseInt(br.readLine());
		int netN = Integer.parseInt(br.readLine());
	
		int[][] map = new int[comN+1][comN+1];	
		boolean[] v = new boolean[comN+1];
		
		for (int i = 0; i < netN; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = 1;
			map[b][a] = 1;
		}
		
		int count = 0;
		Queue<Integer> q = new LinkedList<>();
		
		q.offer(1);
		v[1] = true;
		
		while(!q.isEmpty()) {
			count++;
			int vi = q.poll();
			
			for (int i = 1; i < map.length; i++) {
				if (map[vi][i]==1 && !v[i]) {
					v[i] = true;
					q.offer(i);
				}
			}
		}
		System.out.println(count-1);
	}
}

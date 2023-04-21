import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_S2_20006_랭킹전대기열 {

	public static class Room {
		int level;
		int cnt;
		
		public Room(int level, int cnt) {
			this.level = level;
			this.cnt = cnt;
		}
	}
	
	public static class Player implements Comparable<Player> {
		String nickname;
		int level;
		int room_no;
		
		public Player(String nickname, int level, int room_no) {
			this.nickname = nickname;
			this.level = level;
			this.room_no = room_no;
		}
		
		public int compareTo(Player o) {
			if(this.room_no == o.room_no)
				return this.nickname.compareTo(o.nickname);
			return this.room_no - o.room_no;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int p = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		ArrayList<Room> rooms = new ArrayList<>();
		PriorityQueue<Player> players = new PriorityQueue<>();
		
		for (int i = 0; i < p; i++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			String n = st.nextToken();
			
			boolean exist = false;  // 입장 가능한 방이 존재하는지
			for(int j = 0; j < rooms.size(); j++) {
				Room cur = rooms.get(j);
				
				if(l >= cur.level-10 && l <= cur.level+10 && cur.cnt < m) {
					rooms.get(j).cnt = rooms.get(j).cnt+1;
					players.add(new Player(n, l, j));
					exist = true;
					break;
				}
			}
			
			if(!exist) {  // 입장 가능한 방 없을 때 새로 만듦
				rooms.add(new Room(l, 1));
				players.add(new Player(n, l, rooms.size()-1));
			}
		}
		
		int prev = -1;
		while(!players.isEmpty()) {
			Player cur = players.poll();
			if(prev != cur.room_no) {  // 방 번호가 바뀌면 새로운 방 시작인것
				prev = cur.room_no;
				if(rooms.get(cur.room_no).cnt == m)
					sb.append("Started!\n");
				else sb.append("Waiting!\n");
			}
			sb.append(cur.level+" "+cur.nickname+"\n");
		}
		
		System.out.println(sb);
	}

}

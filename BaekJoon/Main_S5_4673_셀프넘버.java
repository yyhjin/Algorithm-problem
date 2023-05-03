
public class Main_S5_4673_셀프넘버 {

	static int[] nums = new int[10001];
	
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 1; i < 10001; i++) {
			self(i);
		}

		for (int i = 1; i < 10001; i++) {
			if(nums[i] == 0) sb.append(i+"\n");
		}
		
		System.out.println(sb);
	}

	private static void self(int n) {
		int sum = n;
		String s = Integer.toString(n);
		for (int i = 0; i < s.length(); i++) {
			sum += s.charAt(i) - '0';
		}
		
		if(sum <= 10000 && sum != n) {
			nums[sum]++;
		}
	}

}

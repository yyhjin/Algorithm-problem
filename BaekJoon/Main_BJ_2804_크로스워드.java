import java.util.Scanner;

public class Main_BJ_2804_크로스워드 {

	static char[] c1, c2;
	static int index1, index2;
	
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		String s1 = scann.next();
		String s2 = scann.next();
		
		c1 = s1.toCharArray();
		c2 = s2.toCharArray();
				
		Loop1 :
		for (int i = 0; i < c1.length; i++) {
			Loop2 : 
			for (int j = 0; j < c2.length; j++) {
				if (c2[j]==c1[i]) {
					index1 = i;
					index2 = j;
					break Loop1;
				}
			}
		}
		
		for (int i = 0; i < index2; i++) 
			print2(i);
		
		System.out.println(s1); //첫번째 문자열
		
		for (int i = index2+1; i < c2.length; i++) 
			print2(i);

		
	}

	private static void print2(int i) {
		for (int j = 0; j < index1; j++) {
			System.out.print(".");
		}
		System.out.print(c2[i]);
		for (int j = index1+1; j < c1.length; j++) {
			System.out.print(".");				
		}
		System.out.println();
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B4_5543_상근날드 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int burger = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			int price = Integer.parseInt(br.readLine());
			burger = Math.min(price, burger);
		}
		
		int drink = Integer.MAX_VALUE;
		for (int i = 0; i < 2; i++) {
			int price = Integer.parseInt(br.readLine());
			drink = Math.min(price, drink);
		}
		
		System.out.println(burger+drink-50);
	}

}

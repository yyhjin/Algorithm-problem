import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main_B2_1076_저항 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		HashMap<String, Integer> hash = new HashMap<>();
		hash.put("black", 0);
		hash.put("brown", 1);
		hash.put("red", 2);
		hash.put("orange", 3);
		hash.put("yellow", 4);
		hash.put("green", 5);
		hash.put("blue", 6);
		hash.put("violet", 7);
		hash.put("grey", 8);
		hash.put("white", 9);
		
		long value = 0;
		value += (hash.get(br.readLine())*10) + hash.get(br.readLine());
		value *= Math.pow(10, hash.get(br.readLine()));
		
		System.out.println(value);
	}

}

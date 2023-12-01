import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B5_4999_아 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String jh = br.readLine();
		String doctor = br.readLine();
		
		System.out.println(jh.length() >= doctor.length()?"go":"no");
	}

}

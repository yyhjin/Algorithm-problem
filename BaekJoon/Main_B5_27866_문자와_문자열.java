import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B5_27866_문자와_문자열 {

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      String S = br.readLine();
      int i = Integer.parseInt(br.readLine());
      
      System.out.println(S.charAt(i-1));
   }

}

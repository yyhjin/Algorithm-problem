import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B3_2562_최댓값 {

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int[] nums = new int[10];
      
      int max = 0;
      int maxIdx = -1;
      for (int i = 1; i <= 9; i++) {
         nums[i] = Integer.parseInt(br.readLine());
         if(nums[i] > max) {
            max = nums[i];
            maxIdx = i;
         }
      }
      
      System.out.println(max+"\n"+maxIdx);
   }

}

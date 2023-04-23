import java.io.*;
import java.util.*;

class Solution {
    
    static int student, sport, max;
    static int[] choice;
    static boolean[] v;
    
    public int solution(int[][] ability) {
        int answer = 0;
        
        student = ability.length;
        sport = ability[0].length;
        choice = new int[sport];
        v = new boolean[student];
        
        dfs(0, ability);
        answer = max;
        return answer;
    }
    
    public static void dfs(int cnt, int[][] ability) {
        if(cnt == sport) {
            int sum = 0;
            for(int i = 0; i < sport; i++) {
                sum += choice[i];
            }
            max = Math.max(max, sum);
            return;
        }
        for(int i = 0; i < student; i++) {
            if(v[i]) continue;
            
            v[i] = true;
            choice[cnt] = ability[i][cnt];
            dfs(cnt+1, ability);
            v[i] = false;
        }
    }
}
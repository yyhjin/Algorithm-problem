import java.io.*;
import java.util.*;

class Solution {
    public String solution(String input_string) {
        String answer = "";
        
        HashMap<Character, ArrayList<Integer>> hash = new HashMap<>();
        for(int i = 0; i < input_string.length(); i++) {
            char c = input_string.charAt(i);
            
            if(!hash.containsKey(c)) {
                ArrayList<Integer> arr = new ArrayList<>();
                hash.put(c, arr);
            }
            hash.get(c).add(i);
        }
        
        char[] alpha = new char[26];
        Arrays.fill(alpha, '-');
        int index = 0;
        for(char key : hash.keySet()) {
            ArrayList<Integer> idx = hash.get(key);
            if(idx.size()<2) continue;
            
            boolean check = false;
            for(int i = 1; i < idx.size(); i++) {
                if(idx.get(i)-idx.get(i-1) > 1) {
                    check = true;
                    break;
                }
            }
            if(check) {
                alpha[index] = key;
                index++;
            }
        }
        
        Arrays.sort(alpha);
        if(index == 0) answer = "N";
        else {
            for(int i = 0; i < 26; i++) {
                char c = alpha[i];
                if(c == '-' ) continue;
                else answer += c;
            }
        }
        
        return answer;
    }
}
import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < want.length; i++){
            map.put(want[i], number[i]);
        }
        
        loop:
        for(int i = 0; i <= discount.length - 10; i++) {
            HashMap<String, Integer> check = new HashMap<>(map);
            
            for(int j = i; j < i+10; j++) {
                String now = discount[j];
                
                if(check.containsKey(now)){
                    check.put(now, check.get(now)-1);
                } else continue loop;
            }
            
            for(String key : check.keySet()){
                if(check.get(key) > 0) continue loop;
            }
            answer++;
        }
        
        return answer;
    }
}
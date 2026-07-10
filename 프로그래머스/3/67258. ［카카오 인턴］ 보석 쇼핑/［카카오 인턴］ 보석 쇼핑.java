import java.util.*;
class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        
        HashSet<String> set = new HashSet<>(Arrays.asList(gems));
        
        int total = set.size(); //총 보석 종류 개수
        
        answer[0] = 0;
        answer[1] = gems.length-1;
        
        int left = 0;
        int right = 0;
        
        HashMap<String, Integer> map = new HashMap<>();
        
        map.put(gems[0],1);
        
        while(true) {
            
            //투포인터 이동 로직
            
            if(map.size() == total){
               if ((answer[1] - answer[0]) > (right - left)) {
                    answer[0] = left;
                    answer[1] = right;
                }
                
                map.put(gems[left], map.get(gems[left])-1);
                
                if(map.get(gems[left]) == 0) map.remove(gems[left]);
                left++;
            } else {
                right++;
                
                if(right == gems.length) break;
                
                map.put(gems[right], map.getOrDefault(gems[right],0)+1);
                
            }
           
        }
        answer[0] += 1;
        answer[1] += 1;
        
        return answer;
    }

}
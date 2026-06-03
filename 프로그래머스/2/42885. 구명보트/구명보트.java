import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        
        int idx1 = 0; //가벼운쪽 부터 체크하는 포인터
        int idx2 = people.length-1; //무거운쪽 부터 체크하는 포인터
        
        while(idx1 <= idx2) {
            
            if(idx1 == idx2) {
                answer++;
                break;
            }
            
            if(people[idx1] + people[idx2] <= limit) {
                idx1++;
                idx2--;
            } else if(people[idx1] + people[idx2] > limit) {
                idx2--;
            }
            answer++;
        }
        
        
        return answer;
    }
}
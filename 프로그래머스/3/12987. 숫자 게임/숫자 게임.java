import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        // 1 3 5 7
        // 2 6 8 
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        int a_idx = 0;
        int b_idx = 0;
         
        while(a_idx < A.length && b_idx < B.length) {
            
            if(A[a_idx] < B[b_idx]) {
                answer++;
                a_idx++;
                b_idx++;
            } else {
                b_idx++;
            }
            
        }
        
        
        return answer;
    }
}
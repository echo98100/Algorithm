class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {};
        
        int left = 0;
        int right = 0;
        int sum = sequence[0];
        
        int start = 0;
        int end = sequence.length -1;
        
        while (right < sequence.length){
            
            if (sum == k) {
                if ( (right - left) < (end - start) ) {
                    start = left;
                    end = right;
                }
            }
            
            if (sum < k) {
                right++;
                
                if(right == sequence.length) break;
                
                sum += sequence[right];
            } else {
                sum -= sequence[left];
                left++;
            }
            
        }
        
        
        
        return new int[]{start, end};
    }
}
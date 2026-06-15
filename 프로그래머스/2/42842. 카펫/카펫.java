class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int size = brown + yellow;
        
        for(int h = 1; h <= size/2; h++) {
            
            if(size % h != 0) {
                continue;
            }
            int w = size/h;
            
            if((h-2) * (w-2) == yellow) {
                answer[0] = h;
                answer[1] = w;
            }
        }
        
        
        return answer;
    }
}
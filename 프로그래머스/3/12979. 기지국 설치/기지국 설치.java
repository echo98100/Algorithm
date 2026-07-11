class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        int length = w*2+1;
        int tmp = 0;
        
        for(int station : stations) {
            
            int start = station - w;
            int end = station + w;
            
            int empty_length = start - tmp - 1;
            
            if (empty_length > 0) {
                answer += (empty_length + length -1) / length;
            }
            
            tmp = end;
        }
        
        int empty_length = n - tmp;
        
        if (empty_length > 0) {
            answer += (empty_length + length -1) / length;
        }
        
        return answer;
    }
}
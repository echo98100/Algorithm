import java.util.*;
class Solution {
    
    static List<int[]> arr;
    
    public int[][] solution(int n) {
        
        arr = new ArrayList<>();
        
        hanoi(n,1, 3, 2);
        
        int[][] answer = new int[arr.size()][2];
        for(int i = 0; i < arr.size(); i++){
            answer[i] = arr.get(i);
        }
        
        return answer;
    }
    
    public void hanoi(int n, int start, int to, int mid) {
        if(n == 1) {
            arr.add(new int[]{start, to});
            return;
        }
        // n-1개를 중계로 이동
        hanoi(n-1, start, mid, to);
        arr.add(new int[]{start, to});
        // 중계에서 start를 중계로 써서 목적지로
        hanoi(n-1, mid, to, start);
    }
        
}
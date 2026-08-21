import java.util.*;

class Solution {
    
    static List<Integer>[] arr;
    static int[][] dp;
    
    public int solution(int n, int[][] lighthouse) {
        int answer = 0;
        
        arr = new List[n+1];
        
        for(int i = 0; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }
        
        for(int[] now : lighthouse) {
            
            int from = now[0];
            int to = now[1];
            
            arr[from].add(to);
            arr[to].add(from);
        }
        
        // dp[][0] - 현재 칸이 꺼졌을때 -> 자식은 반드시 on(1)
        // dp[][1] - 현재 칸이 켜졌을때 -> 1 + 자식 노드 0,1 중 최소값(상관없음)
        dp = new int[n+1][2];
        
        dfs(1, 0);

        return Math.min(dp[1][0], dp[1][1]);
    }
    
    public void dfs(int root, int parent){
        
        //루트1부터 내려감
        
        //현재 노드 off
        dp[root][0] = 0;
        
        //현재 노드 on
        dp[root][1] = 1;
        
        //현재 노드와 연결된 자식들에 대해서
        for(int child : arr[root]) {
            
            //부모노드로 올라가지는 않는다
            if (child == parent) continue;
            
            //dfs로 내려가기
            dfs(child, root);
            
            // 현재 노드가 꺼져있다면 child는 켜져있어야 하니 누적합
            dp[root][0] += dp[child][1];
            
            // 현재 노드가 켜져있다면 child는 상관없이 최소값
            dp[root][1] += Math.min(dp[child][0], dp[child][1]); 
        }
    }
    
    
}
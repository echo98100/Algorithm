import java.util.*;
class Solution {
    
    static List<Integer>[] adj;
    static boolean[] visited;
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        adj = new List[n+1];
        for(int i = 0; i <= n; i++){
            adj[i] = new ArrayList<>();
        }
        
        for(int[] wire : wires){
            int a = wire[0];
            int b = wire[1];
            
            adj[a].add(b);
            adj[b].add(a);
        }
        
        for(int[] wire : wires){
            int cutA = wire[0];
            int cutB = wire[1];
            
            visited = new boolean[n+1];
            
            int now = dfs(cutA, cutA, cutB);
            
            int other = n- now;
            
            answer = Math.min(answer, Math.abs(now - other));
        }
        
        
        return answer;
    }
    
    public int dfs(int node, int cutA, int cutB){
        
        visited[node] = true;
        int count = 1;
        
        for(int next : adj[node]) {
            
            if(visited[next]) continue;
            
            if(next == cutB) continue;
            
            count += dfs(next, cutA, cutB);
        }
        
        return count;
    }
}
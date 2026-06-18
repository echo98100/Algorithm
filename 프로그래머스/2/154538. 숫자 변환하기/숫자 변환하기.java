import java.util.*;
class Solution {
    
    static boolean[] visited;
    
    public int solution(int x, int y, int n) {
        int answer = 0;
        
        visited = new boolean[1000001];
        
        return bfs(x,y,n);
    }
    
    public int bfs(int x, int y, int n) {
        
        int count = 0;
        
        Queue<Integer> q = new ArrayDeque<>();
        
        q.add(x);
        visited[x] = true;
        
        while(!q.isEmpty()){
            
            int size = q.size();
            
            for(int i = 0; i < size; i++) {
                
                int now = q.poll();
                
                if(now == y) {
                    return count;
                }
                
                int[] nexts = {
                    now+n,
                    now*2,
                    now*3
                };
                
                for(int next : nexts) {
                    if(next > y) continue;
                    if(visited[next]) continue;
                    
                    visited[next] = true;
                    q.add(next);
                }
                
            }
            
            count++;
        }
        
        return -1;
    }
    
}
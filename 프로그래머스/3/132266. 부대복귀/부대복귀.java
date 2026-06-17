import java.util.*;
class Solution {
    
    static ArrayList<Integer>[] list;
    static int[] dist;
    static int N;
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];

        list = new ArrayList[n+1];
        for(int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        
        for(int[] arr : roads) {
            int from = arr[0];
            int to = arr[1];
            
            list[from].add(to);
            list[to].add(from);
        }
        
        dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        dijkstra(destination);
        
        for(int i = 0; i < sources.length; i++) {
            
            answer[i] = dist[sources[i]] == Integer.MAX_VALUE ? -1 : dist[sources[i]];
            
        }
        
        return answer;
    }
    
    public void dijkstra(int start) {
        
        Queue<Integer> q = new ArrayDeque<>();
        
        dist[start] = 0;
        q.add(start);
        
        while(!q.isEmpty()) {
            
            int now = q.poll();
            
            for(int next : list[now]) {
                
                if(dist[next] > dist[now] + 1) {
                    dist[next] = dist[now] + 1;
                    q.add(next);
                }
            }
        }
    }
}
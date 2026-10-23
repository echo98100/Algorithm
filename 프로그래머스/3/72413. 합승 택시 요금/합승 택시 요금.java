import java.util.*;

class Solution {
    
    static class Node implements Comparable<Node>{
        int end;
        int cost;
        
        public Node(int end, int cost){
            this.end = end;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node o){
            return this.cost - o.cost;
        }
        
    }
    
    static List<Node>[] adjList;
    
    static int N;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        
        N = n;
        final int INF = Integer.MAX_VALUE;
        
        int answer = INF;
        
        adjList = new ArrayList[N+1];
        for(int i = 1; i <= N; i++){
            adjList[i] = new ArrayList<>();
        }
        
        for(int[] fare : fares){
            
            int from = fare[0];
            int to = fare[1];
            int cost = fare[2];
            
            adjList[from].add(new Node(to, cost));
            adjList[to].add(new Node(from, cost));   
        }
        
        int[] together = new int[N+1];
        int[] dist_a = new int[N+1];
        int[] dist_b = new int[N+1];
        
        Arrays.fill(together, INF);
        Arrays.fill(dist_a, INF);
        Arrays.fill(dist_b, INF);
        
        dijkstra(s, together);
        dijkstra(a, dist_a);
        dijkstra(b, dist_b);
        
        for(int i = 1; i <= N; i++){
            
            answer = Math.min(answer, together[i]+dist_a[i]+dist_b[i]);
            
        }
        
        return answer;
    }
    
    public void dijkstra(int start, int[] dist){
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        dist[start] = 0;
        pq.add(new Node(start, 0));
        
        while(!pq.isEmpty()){
            
            Node now = pq.poll();
            
            for(Node next : adjList[now.end]){
                
                if(dist[next.end] > dist[now.end]+next.cost) {
                    dist[next.end] = dist[now.end]+next.cost;
                    pq.add(new Node(next.end, dist[next.end]));
                }
                
            }
            
        }
        
    }
}
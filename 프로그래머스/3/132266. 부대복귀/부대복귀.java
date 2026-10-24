import java.util.*;

class Solution {
    
    static class Node implements Comparable<Node>{
        int node, weight;
        
        public Node(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
        
        @Override
        public int compareTo(Node o){
            return this.weight - o.weight;
        }
    }
    
    static int N;
    
    static int[] dist;
    static List<Integer>[] adjList;
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        
        N=n;
        
        adjList = new List[N+1];
        for(int i = 1; i <= N; i++){
            adjList[i] = new ArrayList<>();
        }
        
        for(int[] road : roads){
            int from = road[0];
            int to = road[1];
            
            adjList[from].add(to);
            adjList[to].add(from);
        }
        
        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        dijkstra(destination);
        
        for(int i = 0; i < sources.length; i++){
            
            if(dist[sources[i]] == Integer.MAX_VALUE) answer[i] = -1;
            else
                answer[i] = dist[sources[i]];
        }
        
        
        return answer;
    }
    
    public void dijkstra(int start){
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        dist[start] = 0;
        pq.add(new Node(start, 0));
        
        while(!pq.isEmpty()){
            
            Node now = pq.poll();
            
            if(now.weight > dist[now.node]) continue;
            
            for(int edge : adjList[now.node]){
                
                if(dist[edge] > now.weight + 1){
                    dist[edge] = now.weight + 1;
                    pq.add(new Node(edge, dist[edge]));
                }
                
            }
            
        }
        
    }
}
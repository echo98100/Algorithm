import java.util.*;

class Solution {
    
    static int N;
    
    static List<Node>[] adjList;
    
    static int[] dist;
    
    static class Node implements Comparable<Node>{
        
        int to;
        int weight;
        
        public Node (int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
        
        @Override
        public int compareTo(Node o){
            return o.weight - this.weight;
        }
        
    }
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        adjList = new ArrayList[N+1];
        
        for(int i = 1; i <= N; i++){
            adjList[i] = new ArrayList<>();
        }
        
        for(int[] r : road) {
            
            int from = r[0];
            int to = r[1];
            int weight = r[2];
            
            adjList[from].add(new Node(to, weight));
            adjList[to].add(new Node(from, weight));
            
        }
        
        dijkstra(1, N);
        
        for(int n : dist) {
            
            if(n <= K) answer++;
            
        }

        return answer;
    }
    
    public void dijkstra(int start, int N) {
        
        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        dist[start] = 0;
        pq.add(new Node(start, 0));
        
        while(!pq.isEmpty()) {
            
            Node now = pq.poll();
            
            for(Node next : adjList[now.to]){
                
                if(dist[next.to] > dist[now.to] + next.weight){
                    dist[next.to] = dist[now.to] + next.weight;
                    
                    pq.add(new Node(next.to, dist[next.to]));
                }
                
            }
            
        }
    }
}
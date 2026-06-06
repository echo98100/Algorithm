import java.util.*;
class Solution {
    
    static int[] dist;
    
    static class Node implements Comparable<Node>{
        int index;
        int cost;
        
        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
        
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
    
    static ArrayList<Node>[] list;
    static boolean[] visited;
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        list = new ArrayList[N+1];
        for(int i = 0; i <= N; i++){
            list[i] = new ArrayList<>();
        }
        
        for(int[] arr : road) {
            int a = arr[0];
            int b = arr[1];
            int c = arr[2];
            
            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }
        
        visited = new boolean[N+1];
        
        dijkstra(1, N);
        
        for(int n : dist) {
            if(n <= K) answer++;
        }
        
        
        
        return answer;
    }
    
    public void dijkstra(int start, int num) {
        
        dist = new int[num+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        dist[start] = 0;
        pq.add(new Node(start, 0));
        
        while(!pq.isEmpty()){
            
            Node now = pq.poll();
            
            if(visited[now.index]) continue;
            visited[now.index] = true;
            
            for(Node next : list[now.index]) {
                
                if(dist[next.index] > dist[now.index] + next.cost){
                    dist[next.index] = dist[now.index] + next.cost;
                    pq.add(new Node(next.index, dist[next.index]));
                }
                
            }
            
            
            
        }
        
    }
}
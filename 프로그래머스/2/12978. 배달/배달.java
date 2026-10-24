import java.util.*;
class Solution {
    
    // 인접 리스트용 Edge 클래스
    static class Edge {
        int to, cost;
        
        public Edge(int to, int cost){
            this.to = to;
            this.cost = cost;
        }
    }
    
    // 다익스트라용 현재 노드와 가중치를 가지는 클래스
    static class Node implements Comparable<Node> {
        
        int node, weight;
        
        public Node(int node, int weight){
            this.node = node;
            this.weight = weight;
        }
        
        @Override
        public int compareTo(Node o){
            return this.weight - o.weight;
        }
    }
    
    static int[] dist;
    
    static List<Edge>[] adjList;
    
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        adjList = new List[N+1];
        for(int i = 1; i <= N; i++){
            adjList[i] = new ArrayList<>();
        }
        
        for(int[] r : road){
            int from = r[0];
            int to = r[1];
            int cost = r[2];
            
            adjList[from].add(new Edge(to, cost));
            adjList[to].add(new Edge(from, cost));
        }
        
        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dijkstra(1);
        
        for(int n : dist) {
            if(n <= K) answer++;
        }
        
        
        return answer;
    }
    
    public void dijkstra(int start) {
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        // 시작 노드의 dist 값을 0으로 초기화하고 우선순위큐에 현재 노드의 번호와 현재까지의 가중치 0으로 노드 만들어 넣음
        pq.add(new Node(start, 0));
        dist[start] = 0;
        
        // 큐가 빌 때까지 반복
        while(!pq.isEmpty()){
            
            Node now = pq.poll();
            
            // 현재 노드에 연결되어 있는 엣지들을 가져와서 반복
            for(Edge next : adjList[now.node]) {
                
                // 다음 엣지까지의 최소가중치(dist[]) 값보다 현재까지의 가중치와, 연결된 다음 노드까지의 비용 합한게 더 작다면 교체 진행
                if(dist[next.to] > now.weight + next.cost){
                    dist[next.to] = now.weight + next.cost;
                    pq.add(new Node(next.to, dist[next.to]));
                }
                
            }
            
        }
        
        
    }
    
}
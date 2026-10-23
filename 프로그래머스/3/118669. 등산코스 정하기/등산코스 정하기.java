import java.util.*;

class Solution {
    
    static class Node implements Comparable<Node> {
        int to, cost;
        
        public Node(int to, int cost){
            this.to = to;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node o){
            return this.cost - o.cost;
        }
    }
    
    static List<Node>[] adjList;
    
    static int N;
    
    static int[] dist;
    
    static boolean[] isGate;
    static boolean[] isSummit;
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = new int[2];
        
        N = n;
        
        adjList = new List[N+1];
        for(int i = 1; i <= N; i++){
            adjList[i] = new ArrayList<>();
        }
        
        for(int[] path : paths){
            int from = path[0];
            int to = path[1];
            int cost = path[2];
            
            adjList[from].add(new Node(to, cost));
            adjList[to].add(new Node(from, cost));
        }
        
        isGate = new boolean[N+1];
        isSummit = new boolean[N+1];
        
        for(int gate : gates){
            isGate[gate] = true;
        }
        for(int summit : summits) {
            isSummit[summit] = true;
        }
        
        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        // 다익스트라 돌리고, dist 중 산봉우리 해당하는 노드 중 가장 작은 값이 정답
        dijkstra(gates);
        
        int min = Integer.MAX_VALUE;
        
        Arrays.sort(summits);
        
        for(int summit : summits){
            
            if(min > dist[summit]) {
                min = dist[summit];
                answer[0] = summit;
                answer[1] = min;
            }
            
        }
        
        return answer;
    }
    
    // 멀티 소스 다익스트라 구현
    public void dijkstra(int[] gates){
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        for(int gate : gates){
            
            dist[gate] = 0;
            pq.add(new Node(gate, 0));
            
        }
        
        while(!pq.isEmpty()){
            
            Node now = pq.poll();
            
            // 이미 처리되어있는 가중치가 더 짧다면 스킵
            if(now.cost > dist[now.to]) continue;
            
            // 산봉우리 도착하면 스킵 - 단방향만 구하면 되니까
            if(isSummit[now.to]) continue;
            
            for(Node next : adjList[now.to]) {
                
                int nextIdx = next.to;
                // 다음으로 올 거는 현재까지의 Intensity(지금까지 최댓값)과 다음으로 가는 비용 중 더 큰값이 되어야 함
                int nextCost = Math.max(now.cost, next.cost);
                
                if(dist[nextIdx] > nextCost){
                    dist[nextIdx] = nextCost;
                    pq.add(new Node(nextIdx, nextCost));
                }
            }
        }
        
    }
}
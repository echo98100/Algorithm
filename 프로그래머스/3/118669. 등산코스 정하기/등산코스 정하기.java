import java.util.*;
class Solution {
    
    // 인접 리스트용 간선 클래스 목적지. 노드번호와 해당 노드까지의 비용을 가짐
    static class Edge {
        int to, cost;
        public Edge (int to, int cost){
            this.to = to;
            this.cost = cost;
        }
    }
    
    // 다익스트라용 현재 노드 번호와 현재 노드까지 오는데 든 가장 큰 intensity를 필드로 가짐
    static class Node implements Comparable<Node>{
        int node, intensity;
        
        public Node (int node, int intensity){
            this.node = node;
            this.intensity = intensity;
        }
        
        @Override
        public int compareTo(Node o){
            return this.intensity - o.intensity;
        }
    }
    
    static int N;
    static boolean[] isGate;
    static boolean[] isSummit;
    
    static List<Edge>[] adjList;
    
    static int[] dist;
    
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = new int[2];
        
        N=n;
        
        adjList = new List[N+1];
        for(int i = 1; i <= N; i++){
            adjList[i] = new ArrayList<>();
        }
        
        for(int[] path : paths){
            int from = path[0];
            int to = path[1];
            int cost = path[2];
            
            adjList[from].add(new Edge(to, cost));
            adjList[to].add(new Edge(from, cost));
        }
        
        isGate = new boolean[N+1];
        isSummit = new boolean[N+1];
        
        for(int gate : gates){
            isGate[gate] = true;
        }
        for(int summit : summits){
            isSummit[summit] = true;
        }
        
        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        dijkstra(gates);
        
        Arrays.sort(summits);
        
        int min = Integer.MAX_VALUE;
        for(int summit : summits){
            if(min > dist[summit]){
                min = dist[summit];
                answer[0] = summit;
                answer[1] = min;
            }
        }
        
        return answer;
    }
    
    // 출발지가 여러개이므로 멀티소스 다익스트라로 구현해 한번에 처리
    public void dijkstra(int[] gates) {
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        //gate를 모두 dist 0 으로 초기화하고 큐에 노드로 만들어 넣음
        for(int gate : gates){
            dist[gate] = 0;
            pq.add(new Node(gate, 0));
        }
        
        
        while(!pq.isEmpty()){
            
            Node now = pq.poll();
            // now.node 는 현재 노드 번호
            // now.intensity는 노드 생성 순간의 그 노드까지 오는데 든 intensity의 최대값
            
            // 만약 정상에 도착했다면 더 안나가도 되므로 스킵
            if(isSummit[now.node]) continue;
            
            // 현재 노드의 생성 순간의 intensity가 dist에 저장된 최신 intensity 최소값 보다 크면 과거 값이므로 스킵
            if(now.intensity > dist[now.node]) continue;
            
            for(Edge edge : adjList[now.node]) {
                
                // 만약 다음 가는게 입구라면 스킵
                if(isGate[edge.to]) continue;
                
                // 다음으로 갈 새로운 intensity 값은 현재의 intensity(현재 노드까지 오는데 든 최대 intensity)와
                // 다음으로 갈 간선의 cost(이게 곧 intensity니까) 중 큰 값
                int newIntensity = Math.max(now.intensity, edge.cost);
                
                if(dist[edge.to] > newIntensity){
                    dist[edge.to] = newIntensity;
                    pq.add(new Node(edge.to, newIntensity));
                }
                
            } 
            
            
        }
        
        
    }
    
    
}
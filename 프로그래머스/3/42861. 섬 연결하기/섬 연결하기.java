import java.util.*;

class Solution {
    
    static class Edge implements Comparable<Edge> {
        
        int from, to, cost;
        
        public Edge(int from, int to, int cost){
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Edge o){
            return this.cost - o.cost;
        }
    }
    
    static int[] parent;
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        parent = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
        
        List<Edge> edges = new ArrayList<>();
        
        for(int[] cost : costs){
            edges.add(new Edge(cost[0], cost[1], cost[2]));
        }
        
        Collections.sort(edges);
        
        int count = 0;
        
        for(Edge edge : edges){
            
            if(union(edge.from, edge.to)){
                answer += edge.cost;
                count++;
                
                if(count == n-1) break;
            }
            
        }
        
        
        return answer;
    }
    
    // 유니온파인드
    
    public int find(int x){
        if(parent[x] == x) return x;
        
        return parent[x] = find(parent[x]);
        
    }
    
    public boolean union(int x1, int x2){
        
        int p1 = find(x1);
        int p2 = find(x2);
        
        if(p1 == p2) return false;
        
        if(p1 > p2) parent[p1] = p2;
        else parent[p2] = p1;
        
        return true;
        
    }
    
}
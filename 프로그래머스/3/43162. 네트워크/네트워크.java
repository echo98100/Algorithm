class Solution {
    
    static int parent[];
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        parent = new int[n+1];
        for(int i = 1; i <= n; i++){
            parent[i] = i;
        }
        
        for(int r = 0; r < n; r++){
            for(int c = 0; c < n; c++){
                if(computers[r][c] == 1){
                    union(r,c);
                }
            }
        }
        
        for(int i = 0; i < n; i++){
            if(parent[i] == i) answer++;
        }
        
        return answer;
    }
    
    // 유니온파인드 구현
    
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
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        
        int n1 = cards1.length;
        int n2 = cards2.length;
        
        int idx1 = 0;
        int idx2 = 0;
        
        for(int i = 0; i < goal.length; i++) {
            
            String now = goal[i];
            
           if(idx1 < n1 && now.equals(cards1[idx1])) {
                idx1++;
                continue;
            }else if(idx2 < n2 && now.equals(cards2[idx2])) {
                idx2++;
                continue;
            }else {
               return "No";
            }
            
        }
        
        return "Yes";
    }
}
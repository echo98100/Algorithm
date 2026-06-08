class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        
        int len = p.length();
        
        for(int i = 0; i <= t.length() - len; i++) {
            
            String now = t.substring(i, i+len);
            
            if(Long.parseLong(p) >= Long.parseLong(now)) answer++;
            
        }
        
        return answer;
    }
}
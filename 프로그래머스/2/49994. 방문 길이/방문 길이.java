import java.util.*;
class Solution {
    public int solution(String dirs) {
        int answer = 0;
        
        Set<String> set = new HashSet<>();
        
        int r = 5;
        int c = 5;
        
        for(int i = 0; i < dirs.length(); i++) {
            
            int nr = r;
            int nc = c;
            
            switch(dirs.charAt(i)) {
                case 'L' :
                    nc--;
                    break;
                
                case 'R' :
                    nc++;
                    break;
                case 'U' :
                    nr--;
                    break;
                case 'D' :
                    nr++;
                    break;
            }
            
            if(nr < 0 || nr > 10 || nc < 0 || nc > 10){
                continue;
            }
            
            //양방향 모두 저장
            set.add(r+ " " + c + " " + nr + " " + nc);
            set.add(nr + " " + nc + " " + r + " " + c);
            
            r = nr;
            c = nc;
            
        }
        
        return set.size() /2;
    }
}
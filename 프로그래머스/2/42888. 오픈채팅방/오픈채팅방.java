import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        List<String> answer = new ArrayList<>();
        
        Map<String, String> user = new HashMap<>();
        
        for(String s : record) {
            
            String[] now = s.split(" ");
            
            if(now[0].equals("Enter") || now[0].equals("Change")){
                user.put(now[1], now[2]);
            }
        }
        
        for(String s : record) {
            
            String[] now = s.split(" ");
            
            StringBuilder sb = new StringBuilder();
            
            switch(now[0]){
                case "Enter":
                    answer.add(user.get(now[1])+"님이 들어왔습니다.");
                    break;
                case "Leave":
                    answer.add(user.get(now[1])+"님이 나갔습니다.");
                    break;
              
            }
            
            
        }
        
         
        return answer.stream().toArray(String[]::new);
    }
}
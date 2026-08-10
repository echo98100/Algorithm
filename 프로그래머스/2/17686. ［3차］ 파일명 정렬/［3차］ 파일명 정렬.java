import java.util.*;

class Solution {
    
    static class File implements Comparable<File> {
        String head;
        int number, index;
        
        public File(String head, int number, int index) {
            this.head = head;
            this.number = number;
            this.index = index;
        }
        
        @Override
        public int compareTo(File o) {
            
            if(!this.head.equals(o.head)) {
                return this.head.compareTo(o.head);
            } else if(this.number != o.number)
                return this.number - o.number;
            else
                return this.index - o.index;
        }
        
    }
    
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        
        PriorityQueue<File> pq = new PriorityQueue<>();
        
        for(int n = 0; n < files.length; n++) {
            String file = files[n];
            
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            
            int num_index = 0;
            // head 계산
            for(int i = 0; i < file.length(); i++) {
                
                if(Character.isDigit(file.charAt(i))) {
                    num_index = i;
                    break;
                }
                sb1.append(file.charAt(i));
            }
            String head = sb1.toString().toUpperCase();
            
            //number 계산
            for(int i = num_index; i < file.length(); i++){
                
                if(!Character.isDigit(file.charAt(i))){
                    num_index = i;
                    break;
                }
                sb2.append(file.charAt(i));
            }
            int number = Integer.parseInt(sb2.toString());
            
            pq.add(new File(head, number, n));
        }
        
        for(int i = 0; i < files.length; i++){
            
            answer[i] = files[pq.poll().index];
            
        }
        
        return answer;
    }
}
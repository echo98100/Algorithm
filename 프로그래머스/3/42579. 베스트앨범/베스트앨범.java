import java.util.*;
class Solution {
    
    static class Music {
        String genre;
        int play;
        int num;
        public Music(String genre, int play, int num){
            this.genre = genre;
            this.play = play;
            this.num = num;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        
        Map<String, List<Music>> map = new HashMap<>();
        Map<String, Integer> count = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++) {
            
            Music now = new Music(genres[i], plays[i], i);
            
            //키가 있으면 키의 리스트, 없으면 새로운 리스트 생성후 반환
            map.computeIfAbsent(genres[i], key -> new ArrayList<>()).add(now);
            
            //카운트맵에 재생횟수 누적
            count.put(genres[i], count.getOrDefault(genres[i], 0) + plays[i]);
            
        }
        
        //카운트맵 누적 재생횟수 내림차순 정렬
        //카운트맵의 keyset 리스트를 만들어 해당 키의 value값으로 정렬
        List<String> keyset = new ArrayList<>(count.keySet());
        
        keyset.sort(Comparator.comparing((String key) -> count.get(key)).reversed());
        
        for(String key : keyset) {
            
            List<Music> now = map.get(key);
            
            // 재생횟수가 같으면 num 오름차순, 다르면 재생시간 내림차순 정렬
            now.sort((o1, o2) -> {
                if(o1.play == o2.play) {
                    return o1.num - o2.num;
                }
                return o2.play - o1.play;
            });
            
            // 정렬 했으니까 앞에서 두개의 번호만 answer 리스트에 추가, 1개면 size만큼 반복
            for(int i = 0; i < Math.min(2, now.size()); i++) {
                answer.add(now.get(i).num);
            }
        }
        
        //answer 리스트를 배열로 변환해서 반환
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
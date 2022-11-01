package onboarding;

import java.util.*;

/* 기능 목록
1. 친구관계 그래프 Map 생성
2. 그래프에서 user 와 인접한 친구의 친구들에게 +10점
3. visitor +1점
4. 점수, 이름 순으로 정렬
5. 최대 5인 추천 친구 선정
*/

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        // 1. 친구관계 그래프 Map 생성
        Map<String, List<String>> connectMap = new HashMap<>();

        for(List<String> connect : friends) {
            if(connectMap.containsKey(connect.get(0)))
                connectMap.get(connect.get(0)).add(connect.get(1));
            else {
                List<String> friendList = new ArrayList<>();
                friendList.add(connect.get(1));
                connectMap.put(connect.get(0), friendList);
            }

            if(connectMap.containsKey(connect.get(1)))
                connectMap.get(connect.get(1)).add(connect.get(0));
            else {
                List<String> friendList = new ArrayList<>();
                friendList.add(connect.get(0));
                connectMap.put(connect.get(1), friendList);
            }
        }
        return answer;
    }
}

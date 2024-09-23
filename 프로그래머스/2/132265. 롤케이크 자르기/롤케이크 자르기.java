/**
 문제 풀이
 1. 
 -50 ~ 50 정수 101개가 있을때 무분별하게 등장하는데
 뭐가 몇번 나타났는지 정렬을 하고 싶음. 이럴때 어떻게? (카운팅 정렬)
  
 전체를 다 검토해야봐한다 => 완전탐색
 
*/
import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] topping) {
        Map<Integer, Integer> leftMap = new HashMap<>();
        Map<Integer, Integer> rightMap = new HashMap<>();
        
        // 전체 토핑을 rightMap에 담기
        for(int i = 0 ; i < topping.length; i++){
            rightMap.put(topping[i], rightMap.getOrDefault(topping[i], 0) + 1);
        }

        int answer = 0;
        for(int i = 0; i < topping.length ; i++){
            leftMap.put(topping[i], leftMap.getOrDefault(topping[i], 0) + 1); // 왼쪽 토핑에 더해줌
            rightMap.put(topping[i], rightMap.getOrDefault(topping[i], 0) - 1); // 오른쪽 토핑을 빼줘야함
            if(rightMap.get(topping[i]) == 0) rightMap.remove(topping[i]);
            // 갯수 비교
            int leftMapCnt = leftMap.size();
            
            int rightMapCnt = rightMap.size();
            
            if(rightMapCnt == leftMapCnt) answer++;
        }
        return answer;
    }
}
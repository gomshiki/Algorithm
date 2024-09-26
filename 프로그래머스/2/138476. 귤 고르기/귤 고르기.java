/**
귤의 크기를 최소화 : 모든 경우의 수를 확인해야함
귤 크기 배열 최대 기링 : 10만 => 시간 복잡도 생각해야함

그리디 문제 인듯

k = 6
num [1] [2] [3] [4] [5]
cnt  1   2   2   1   2  total : 8

k = 4
num [1] [2] [3] [4] [5]
cnt  1   2   2   1   2  total : 8 

k = 2
num [1] [2] [3] 
cnt  4   3   1  total : 9

모든 숫자를 Map<숫자, 갯수>로 담는다.

내림차순 정렬 or 우선순위 큐 사용
k번 만큼 새로운 Map에 담는다.
Map.size를 출력한다.

*/
import java.util.*;
import java.io.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int a : tangerine){
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        
          
        // Map의 entry들을 Value 값 기준으로 내림차순 정렬하기 위해 List로 변환
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());
        
        // Value 기준으로 내림차순 정렬
        entryList.sort((o1, o2) -> o2.getValue() - o1.getValue());
        
        int count = 0;
        
        // k개의 귤을 채울 때까지 가장 많은 귤부터 선택
        for (Map.Entry<Integer, Integer> entry : entryList) {
            count += entry.getValue();
            answer++;  // 귤 종류 개수를 증가
            
            if (count >= k) {
                break;  // k개 이상의 귤을 선택하면 종료
            }
        }
        return answer;  // 귤의 최소 종류 수 반환
    }
}
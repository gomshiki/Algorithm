import java.util.*;

class Solution {
    int[] ryan = new int[11];
    int[] apeach = new int[11];
    int maxPoint = 0; //라이언이 어피치보다 얻을 점수의 max값
    ArrayList<int[]> combinations = new ArrayList<>();

    public int[] solution(int n, int[] info) {
        int[] answer = {};

        this.apeach = info; //변수명 맞춰주는 용도

        /* 어피치 점수 구하기 */
        int apeachScore = 0;
        for(int i = 0; i < 11; i++) {
            if (apeach[i] > 0) { apeachScore += (10-i); }
        }

        /* maxPoint, combinations 구하기 */
        maxPoint = -apeachScore;
        permutation(0, n, maxPoint);

        /* 조합 고르기 */
        if (maxPoint <= 0) { answer = new int[] {-1}; }
        else { //가장 낮은 점수를 더 많이 맞힌 조합 구하기
            for (int i = 0; i <= 10; i++) { 
                if(combinations.size() == 1) { break; }

                /* 해당 점수를 맞힌 최대 개수 구하기 */
                int maxCount = 0;
                for (int[] ryan : combinations) {
                    maxCount = Math.max(ryan[10-i], maxCount);
                }

                /* 최대 개수를 맞힌 조합만 남기기 */
                int c = 0;
                while(c < combinations.size()) {
                    if(combinations.get(c)[10-i] != maxCount) { combinations.remove(c); }
                    else { c++; }
                }
            }
            answer = combinations.get(0);
        }

        return answer;
    }

    public void permutation(int index, int n, int nowPoint) { 
        //index = ryan{과녁별 화살개수 배열} 인덱스; 
        //n = 라이언이 쏠 수 있는 화살 개수; 
        //nowPoint = 현재 라이언이 어피치보다 얻은 점수

        /* 화살 모두 쏜 후, 이번 조합의 점수 확인 */
        if (n == 0) {            
            if(nowPoint > maxPoint) {
                maxPoint = nowPoint;
                combinations = new ArrayList<>();
                combinations.add(ryan.clone());
            } 
            else if (nowPoint == maxPoint) {
                combinations.add(ryan.clone());
            }
        }

        /* 라이언 {과녁별 화살개수} 조합 만들기 */
        else if (n >= 0 && index < 11) {
            for(int num = 0; num <= apeach[index] + 1; num++) {
                ryan[index] += num; //화살 쏘기

                int nextPoint = nowPoint;
                if(ryan[index] > apeach[index]) { //점수를 라이언이 가져가는 상황
                    if (apeach[index] == 0) { nextPoint += (10 - index); } //어피치가 안쏜 곳일 때
                    else if (apeach[index] > 0) { nextPoint += (10 - index) * 2; } //어피치가 쏜 곳일 때
                }

                permutation(index+1, n-num, nextPoint);

                ryan[index] -= num; //원상 복구
            }
        }
    }
}
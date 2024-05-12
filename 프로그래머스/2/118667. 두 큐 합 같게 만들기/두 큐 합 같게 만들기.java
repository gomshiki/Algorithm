import java.util.LinkedList;
import java.util.List;

public class Solution {

    static long sum1;
    static long sum2;
    static List<Integer> q1 = new LinkedList<>();
    static List<Integer> q2 = new LinkedList<>();

    public long solution(int[] queue1, int[] queue2) {
            setUp(queue1, queue2);
            int qSize = q1.size() + q2.size();
            long sum = sum1 + sum2;

            // 총합이 홀수면 -1 반환
            if (sum % 2 != 0) {
                return -1;
            }

            long moveCount = 0;
            long answer = -1;
        
            while (moveCount <= qSize + 2) {
                if (sum1 > sum2) {
                    int moveNum = q1.remove(0);
                    sum1 -= moveNum;
                    sum2 += moveNum;
                    moveCount++;
                    q2.add(moveNum);
                } else if (sum1 == sum2) {
                    answer = moveCount;
                    break;
                } else if (sum1 < sum2) {
                    int moveNum = q2.remove(0);
                    sum1 += moveNum;
                    sum2 -= moveNum;
                    moveCount++;
                    q1.add(moveNum);
                }

            }
            return answer;

        }

        void setUp(int[] queue1, int[] queue2) {

            for (int a : queue1) {
                q1.add(a);
                sum1 += a;
            }

            for (int b : queue2) {
                q2.add(b);
                sum2 += b;
            }

        }
    
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/18353
 *
 * 1. 입력
 *  1.1 병사수 N ( 1<= N <= 2000 )
 *  1.2 병사의 전투력 정수 배열
 *
 * 2. 풀이
 *  ex) 15 11 4 8 5 2 4 => 15 11 8 5 4 로 내림차순으로 되어야함. 이를 위해 4, 2를 제외시킨것.
 *  2.1 두 값을 비교해 작지않다면 해당 값을 제외 => LinkedList로 정의함
 *  2.2 이때 뺄때마다 cnt + 1
 *
 *
 * 3. 출력
 *  3.1 열외 병사 수
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] power = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            power[i] = Integer.parseInt(st.nextToken());
        }

        // index i 에서 가장 긴 부분수열의 감소량을 저장
        int[] dp = new int[N];

        // 1로 초기화
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (power[j] > power[i]) { // 두 값을 비교
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        // 가장 긴 감소랑 부분수열의 길이를 구하기
        int maxLength = 0;
        for (int i = 0; i < N; i++) {
            if (dp[i] > maxLength) {
                maxLength = dp[i];
            }
        }

        System.out.println(N - maxLength);
    }
}

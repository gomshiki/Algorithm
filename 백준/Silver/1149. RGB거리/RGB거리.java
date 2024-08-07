import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * https://www.acmicpc.net/problem/1149
 * <p>
 * 1번 집의 색은 2번 집의 색과 같지 않아야한다.
 * => 시작 집은 연달아서 같은 색이면 안됨 (R, R ...) X |  (R G ...) O
 * <p>
 * N번 집의 색은 N-1번 집의 색과 같지 않아야한다.
 * => 마지막도 연달아 같은 색이면 안됨 (.. R R) X | (..  R G) O
 * <p>
 * i(2<= i <= N-1)번 집의 색은 i-1번, i+1번 집의 색과 같이 않아야함.
 * => 중간 집들도 연달아 같은 색이면 안됨( ... R R G ...) X | (... G R G ... ) O | (... G R R ...) X
 * <p>
 * 1. 입력
 * 1.1 집의 수 입력받음(2 <= N <= 1000)
 * 1.2 N 개의 줄에 각 집을 R, G, B로 칠하는 비용이 1번 집부터 한줄에 하나씩 주어짐.
 * 1.3 집을 칠하는 비용은 1_000 보다 작거나 같음
 * <p>
 * 2. 풀이
 * 2.1 예제 분석
 * <p>
 * 26 40 83 => 26 : int min1 = boolean[R] = true; Math.min(R,B)
 * 49 60 57 => 57 : int min2 = boolean[R] = true; Math.min(G,B); boolean[B] = true;
 * 13 89 99 => 13 : int min3 = Math.min(R,G,B)  new boolean[], boolean[R] = true;
 * 출력 = min1 + min2 + min3
 * <p>
 * dp = new int[N + 1][3];
 * int temp = Math.min(Math.min(R,G),B);
 * <p>
 * dp[0] =
 * dp[1] =
 * <p>
 * 71 39 44  => dp[0]
 * 32 83 55
 * 51 37 63
 * 89 29 100
 * 83 58 11
 * 65 13 15
 * 47 25 29 => int min7 = Math.min(
 * 60 66 19 => int min8 = Math.min(R,G,B)  new boolean[], boolean[min8] = true;
 * <p>
 * <p>
 * 3. 출력
 * 3.1 모든집을 칠하는 비용의 최솟값을 출력
 */
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] arr;
    static int[][] dp;
    static int R = 0, G = 1, B = 2;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        arr = new int[n + 1][3];
        dp = new int[n + 1][3];

        for (int i = 0; i < n; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        dp[0] = arr[0];

        for (int i = 1; i < n + 1; i++) {
            dp[i][R] = Math.min(dp[i - 1][G] + arr[i][R], dp[i - 1][B] + arr[i][R]);
            dp[i][G] = Math.min(dp[i - 1][R] + arr[i][G], dp[i - 1][B] + arr[i][G]);
            dp[i][B] = Math.min(dp[i - 1][R] + arr[i][B], dp[i - 1][G] + arr[i][B]);
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            if (min > dp[n][i]) {
                min = dp[n][i];
            }
        }

        System.out.println(min);
    }
}

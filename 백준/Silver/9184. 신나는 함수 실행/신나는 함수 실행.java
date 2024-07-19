import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][][] dp = new int[21][21][21]; // 메모이제이션 초기화 : 저장역할

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // -1 -1 -1 이면 종료
            if (a == -1 && b == -1 && c == -1) break;

            int result = w(a, b, c);

            sb.append("w(")
                    .append(a).append(", ")
                    .append(b).append(", ")
                    .append(c).append(") = ")
                    .append(result).append("\n");
        }
        System.out.println(sb);
    }

    static int w(int a, int b, int c) {

        // a, b, c 범위 체크 및 메모이제이션 되어있는 경우
        if (inRange(a, b, c) && dp[a][b][c] != 0) {
            return dp[a][b][c];
        }

        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }

        /**
         * a,b,c 하나라도 20이 넘으면 w(20,20,20) 호출
         * dp[20][20[20] 에 저장하고 반환
         */
        if (a > 20 || b > 20 || c > 20) {
            return dp[20][20][20] = w(20, 20, 20);
        }

        if (a < b && b < c) {
            return dp[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        }

        return dp[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);

    }

    // 배열 참조 시 a,b,c 범위를 체크
    static boolean inRange(int a, int b, int c) {
        return 0 <= a && a <= 20 && 0 <= b && b <= 20 && 0 <= c && c <= 20;
    }

}

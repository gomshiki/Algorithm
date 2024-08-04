
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        dp = new int[n];

        dp[0] = array[0];
        int result = dp[0];  // 초기값을 첫번째 요소로 설정

        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(array[i], dp[i - 1] + array[i]);
            result = Math.max(result, dp[i]);
        }

        System.out.println(result);
    }
}
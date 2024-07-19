import java.util.Scanner;

public class Main {
    static int fibCount = 1;
    static int fibonacciCount = 0; // main 메서드에서 호출 cnt로 1부터 시작
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int fib = fib(N);

        dp = new int[N + 1];
        int fibonacci = fibonacci(N);

        System.out.println(fibCount + " " + fibonacciCount);
    }

    static int fib(int n) {
        if (n == 1 || n == 2) return 1;
        fibCount++;
        return fib(n - 1) + fib(n - 2);
    }

    static int fibonacci(int n) {
        if (n == 1 || n == 2) return 1;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            fibonacciCount++;
        }
        return dp[n];
    }
}

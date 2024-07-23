import java.util.Scanner;

public class Main {
    static int[] arr, result;
    static boolean[] visited;
    static int N, M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt(); // 뽑을 갯수

        // 1 ~ N 까지 숫자를 배열에 저장
        arr = new int[N];
        result = new int[M];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }

        // 1, 2, 3, 4 중 2개만 선택
        backTracking( 0);
        System.out.println(sb);
    }

    static void backTracking(int depth) {
        if (depth == M) {// depth가 M이면 종료되어야함.
            for (int i = 0; i < M; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }else{
            for (int i = 0; i < N; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    result[depth] = arr[i];
                    backTracking(depth + 1);
                    visited[i] = false;
                }
            }
        }
    }
}

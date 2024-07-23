import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// N과M2
// https://www.acmicpc.net/problem/15650
public class Main {

    static int N, M;
    static boolean[] visited;
    static int[] arr, result;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 배열 인수 초기화
        visited = new boolean[N];
        arr = new int[N];
        result = new int[M];

        // 1 ~ N 까지 숫자를 생성 후 배열에 담기
        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }

        backTracking(0, 0);
        System.out.println(sb);
    }

    static void backTracking(int index, int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        } else {
            for (int i = index; i < N; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    result[depth] = arr[i];
                    backTracking(i + 1, depth + 1);
                    visited[i] = false;
                }
            }
        }
    }
}

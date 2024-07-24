import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] arr, result;
    static boolean[] visited;
    static int N, M;
    static LinkedHashSet<String> set = new LinkedHashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        result = new int[M];
        visited = new boolean[N];

        StringTokenizer inputDatas = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(inputDatas.nextToken());
        }

        Arrays.sort(arr);
        backTracking(0);

        for (String s : set) {
            System.out.println(s);
        }
    }

    // 1 7 9 9
    // [1] [9]
    // 1 7 | 1 9 | 1 9
    // 7 1 | 7 9
    static void backTracking(int depth) {
        if (depth == M) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < M; i++) {
                sb.append(result[i]).append(" ");
            }
            set.add(sb.toString());
            return;

        } else {
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

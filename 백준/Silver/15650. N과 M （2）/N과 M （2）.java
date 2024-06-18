import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n, r;
    static boolean[] visited;
    static int[] answer;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        n = Integer.parseInt(split[0]);
        r = Integer.parseInt(split[1]);

        visited = new boolean[n];
        answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] = i + 1;
        }
        result = new int[r];
        comb(0, 0);
    }

    static void comb(int start, int depth) {
        if (depth == r) {
            for (int i = 0; i < r; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
        } else {
            for (int i = start; i < n; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    result[depth] = answer[i];
                    comb(i + 1, depth + 1);
                    visited[i] = false;
                }
            }
        }
    }
}

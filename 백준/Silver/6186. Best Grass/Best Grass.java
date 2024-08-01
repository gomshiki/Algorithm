import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int R, C;
    static char[][] map;
    static int[] dirRow = {-1, 0, 1, 0};
    static int[] dirCol = {0, 1, 0, -1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < C; j++) {
                map[i][j] = split[j].charAt(0);
            }
        }

        int sum = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (!visited[i][j] && map[i][j] == '#') {
                    int result = bfs(i, j);
                    sum += result;
                }
            }
        }
        System.out.println(sum);


    }

    static int bfs(int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});
        visited[row][col] = true; // 시작점은 true 처리

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowRow = now[0];
            int nowCol = now[1];

            for (int i = 0; i < 4; i++) {
                int nextRow = dirRow[i] + nowRow;
                int nextCol = dirCol[i] + nowCol;

                if (validate(nextRow, nextCol)) {
                    if (!visited[nextRow][nextCol] && map[nextRow][nextCol] == '#') {
                        queue.add(new int[]{nextRow, nextCol});
                        visited[nextRow][nextCol] = true;
                    }
                }
            }
        }
        return 1;
    }

    static boolean validate(int row, int col) {
        return row >= 0 && col >= 0 && row < R && col < C;
    }
}

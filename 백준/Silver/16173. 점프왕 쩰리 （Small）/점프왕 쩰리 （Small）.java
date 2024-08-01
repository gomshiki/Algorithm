import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N;
    static boolean[][] visited;
    static int[][] map;
    static int[] dirRow = {-1, 0, 1, 0};
    static int[] dirCol = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        boolean result = bfs(0, 0);
        if (result) {
            System.out.println("HaruHaru");
            return;
        }


        System.out.println("Hing");

    }

    static boolean bfs(int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});
        visited[row][col] = true;

        while (!queue.isEmpty()) {
            int[] nowNode = queue.poll();
            int nowRow = nowNode[0];
            int nowCol = nowNode[1];
            int nowDistance = map[nowRow][nowCol];

            // 종료조건
            if (map[nowRow][nowCol] == -1) {
                return true;
            }

            for (int i = 0; i < 4; i++) {
                int nextRow = dirRow[i] * nowDistance + nowRow;
                int nextCol = dirCol[i] * nowDistance + nowCol;

                if (valdate(nextRow, nextCol)) {
                    if (!visited[nextRow][nextCol]) {
                        queue.add(new int[]{nextRow, nextCol});
                        visited[nextRow][nextCol] = true;
                    }
                }
            }
        }
        return false;
    }

    static boolean valdate(int row, int col) {
        return row >= 0 && col >= 0 && row < N && col < N;
    }
}

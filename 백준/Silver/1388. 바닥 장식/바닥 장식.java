import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] dirRow = {-1, 1};
    static int[] dirCol = {1, -1};
    static boolean[][] visited;
    static char[][] map;
    static int N, M;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = split[j].charAt(0);
            }
        }

        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && map[i][j] == '|') {
                    int result = bfs1(i, j, map[i][j]);
                    sum += result;
                }
            }
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && map[i][j] == '-') {
                    int result = bfs2(i, j, map[i][j]);
                    sum += result;
                }
            }
        }
        System.out.println(sum);
    }

    private static int bfs1(int startRow, int startCol, char targetChar) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startRow, startCol});
        visited[startRow][startCol] = true;

        while (!queue.isEmpty()) {
            int[] nowNode = queue.poll();
            int nowRow = nowNode[0];
            int nowCol = nowNode[1];

            for (int i = 0; i < 2; i++) {
                int nextRow = dirRow[i] + nowRow;

                if (validate(nextRow, nowCol) && !visited[nextRow][nowCol]) {
                    if (map[nextRow][nowCol] == targetChar) {
                        queue.add(new int[]{nextRow, nowCol});
                        visited[nextRow][nowCol] = true;
                    }
                }
            }
        }
        return 1;
    }

    private static int bfs2(int startRow, int startCol, char targetChar) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startRow, startCol});
        visited[startRow][startCol] = true;

        while (!queue.isEmpty()) {
            int[] nowNode = queue.poll();
            int nowRow = nowNode[0];
            int nowCol = nowNode[1];

            for (int i = 0; i < 2; i++) {
                int nextCol = dirCol[i] + nowCol;

                if (validate(nowRow, nextCol) && !visited[nowRow][nextCol]) {
                    if (map[nowRow][nextCol] == targetChar) {
                        queue.add(new int[]{nowRow, nextCol});
                        visited[nowRow][nextCol] = true;
                    }
                }
            }
        }
        return 1;
    }

    static boolean validate(int row, int col) {
        return row >= 0 && col >= 0 && row < N && col < M;
    }

    // 프린트용 함수
    static void print(char[][] arr) {
        for (char[] chars : arr) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }
}

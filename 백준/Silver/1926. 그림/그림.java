import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 입력
 * 1.1 도화지 크기 N * M
 * 1.2 도화지 정보 => int[][] map 에 담기
 * <p>
 * 2. 풀이
 * 2.0   문제 흐름
 * 2.0.1 2중 for문으로 map을 탐색하며 1인 경우 bfs 수행한다.
 * 2.0.2 bfs에서 1만날때마나 더해줘 넓이를 반환한다.
 * 2.0.3 각 넓이를 Math.max로 최대값을 비교해 max 변수에 초기화한다.
 * <p>
 * 3. 출력
 * 3.1 max 변수를 출력한다.
 */
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[][] map;
    static boolean[][] visited;
    static int n, m, max;
    static int[] dirRow = {-1, 0, 1, 0};
    static int[] dirCol = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String[] mapInfo = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(mapInfo[j]);
            }
        }

        max = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    count++;
                    max = Math.max(max, bfs(i, j));
                }
            }
        }
        sb.append(count).append("\n").append(max);
        System.out.println(sb.toString());


    }

    static int bfs(int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});
        visited[row][col] = true;

        int cnt = 1;
        while (!queue.isEmpty()) {
            int[] nowNode = queue.poll();
            int nowRow = nowNode[0];
            int nowCol = nowNode[1];
            for (int i = 0; i < 4; i++) {
                int nextRow = dirRow[i] + nowRow;
                int nextCol = dirCol[i] + nowCol;

                if (validate(nextRow, nextCol)) {
                    if (!visited[nextRow][nextCol] && map[nextRow][nextCol] == 1) {
                        queue.add(new int[]{nextRow, nextCol});
                        visited[nextRow][nextCol] = true;
                        cnt += 1;
                    }
                }
            }
        }
        return cnt;
    }

    static boolean validate(int row, int col) {
        return row >= 0 && col >= 0 && row < n && col < m;
    }
}

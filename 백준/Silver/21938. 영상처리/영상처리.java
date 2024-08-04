import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 입력
 * 1.1 세로길이 N, 가로길이 M => map.size = N*M
 * 1.2 map[i][j] = RGB 정보 ( 0 ~ 255 내의 값 )
 * <p>
 * <p>
 * 2. 풀이
 * 2.1 RGB 평균값이 T보다 크면 255로, 작으면 0으로 새로운 배열에 저장 => 전처리 필요
 * 2.2 새로운 배열의 값이 255이면 물체로 인식
 * 2.3 값이 255인 픽셀 상하좌우에 인접하면 같은 물체로 인식(BFS)
 * <p>
 * 3. 출력
 * 3.1 BFS 결과를 카운팅해서 출력
 */
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[][] preProcessingMap;
    static int n, m, t;
    static boolean[][] visited;
    static int[] dirRow = {-1, 0, 1, 0};
    static int[] dirCol = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        String[] mapSize = br.readLine().split(" ");

        n = Integer.parseInt(mapSize[0]);
        m = Integer.parseInt(mapSize[1]);

        preProcessingMap = new int[n][m];
        visited = new boolean[n][m];

        // 맵정보 입력받기
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                int sum = 0;
                for (int k = 0; k < 3; k++) {
                    sum += Integer.parseInt(st.nextToken());
                }
                preProcessingMap[i][j] = sum / 3;
            }
        }

        t = Integer.parseInt(br.readLine()); // 경계값

        // bfs 수행
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && preProcessingMap[i][j] >= t) {
                    int result = bfs(i, j);
                    answer += result;
                }
            }
        }
        System.out.println(answer);

    }

    static int bfs(int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});
        visited[row][col] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int nowRow = poll[0];
            int nowCol = poll[1];

            for (int i = 0; i < 4; i++) {
                int nextRow = nowRow + dirRow[i];
                int nextCol = nowCol + dirCol[i];

                if (validate(nextRow, nextCol)) {
                    if (!visited[nextRow][nextCol] && preProcessingMap[nextRow][nextCol] >= t) {
                        queue.add(new int[]{nextRow, nextCol});
                        visited[nextRow][nextCol] = true;
                    }
                }
            }
        }
        return 1;
    }

    static boolean validate(int row, int col) {
        return row >= 0 && col >= 0 && row < n && col < m;
    }
}

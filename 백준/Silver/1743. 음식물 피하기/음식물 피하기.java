import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 입력
 *  1.1. N : 통로 세로길이, M : 가로길이, K : 음식물 쓰레기 개수
 *  1.2. K개의 음식물 좌표(r, c)
 *
 * 2. 풀이
 *  2.0.0 최대 넓이인 경우만 뽑아내기 위해 int max = Integer.MIN_VALUE; 초기화
 *  2.0.1 2중 for 반복문으로 map을 탐색하고, 음식물 좌표일 시 bfs 수행
 *  2.0.2 bfs 결과와 max 값을 Math.max로 비교해 max 변수에 항상 최대값으로 초기화
 *  2.0.3 인접한 음식물 크기를 구하기위해 bfs 수행
 *  2.1.1 bfs 수행 시 while 문 앞에서 넓이를 더해줄 area 변수를 초기화
 *  2.1.2 bfs 조건 시 하나씩 더해준다.
 *  2.2.0 dfs로도 수행해보기
 *
 * 3. 출력
 *  3.1 max 변수 출력
 */
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] dirRow = {-1, 0, 1, 0};
    static int[] dirCol = {0, 1, 0, -1};
    static boolean[][] visited;
    static int[][] map;
    static int n, m, k;
    static int cnt = 1; // dfs 수행시 넓이 더해줄 용도

    public static void main(String[] args) throws IOException {
        String[] mapInfo = br.readLine().split(" ");
        n = Integer.parseInt(mapInfo[0]);
        m = Integer.parseInt(mapInfo[1]);
        k = Integer.parseInt(mapInfo[2]);

        map = new int[n][m];
        visited = new boolean[n][m];

        // 음식물 위치 표시
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int row = Integer.parseInt(st.nextToken()) - 1;
            int col = Integer.parseInt(st.nextToken()) - 1;

            map[row][col] = 1;
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    cnt = 1;
                    dfs(i, j);
                    max = Math.max(max, cnt);
                }
            }
        }
        System.out.println(max);
    }

    static void dfs(int row, int col) {
        visited[row][col] = true;

        for (int i = 0; i < 4; i++) {
            int nextRow = dirRow[i] + row;
            int nextCol = dirCol[i] + col;

            if (validate(nextRow, nextCol)) {
                if (!visited[nextRow][nextCol] && map[nextRow][nextCol] == 1) {
                    dfs(nextRow, nextCol);
                    cnt += 1;
                }
            }
        }
    }

    static boolean validate(int row, int col) {
        return row >= 0 && col >= 0 && row < map.length && col < map[0].length;
    }
}

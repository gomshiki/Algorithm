import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 입력
 *  1.1 맵의 크기 : w x h
 *  1.2 0 0 입력되면 프로그램 종료
 *  1.3 h줄에 걸쳐 맵 정보를 0,1 로 주어짐 => int[w][h]
 *  1.4 1은 땅, 0은 바다
 *
 * 2. 풀이
 *  2.1 0 : 바다, 1: 땅 => 2차원 정수배열로 맵정보를 담는다.
 *  2.2 문제에서 가로, 세로, 대각선이 연결되어있으면 한 땅으로 본다 => 8방향 탐색
 *  2.3.1 2중 for문으로 각 좌표에 방문하지 않았을 경우 bfs를 수행한다.
 *  2.3.2 bfs 연결되어있는 land를 순회후 1을 반환한다.
 *  2.3.3 계속해서 2중 For문을 돌며 land찾고 1씩 int sum에 담는다.
 *  2.4 bfs의 반환 타입은 int 이다.
 *  2.4.0 static int bfs(int row, int col) 로 메서드를 정의한다.
 *  2.4.1 Queue<int[]> queueu = new LinkedList<>() 를 초기화한다.
 *  2.4.2 queue 에 시작 row, col 을 담고, 방문처리한다.
 *  2.5 queue 가 빌때까지 while 문을 반복한다.
 *  2.5.1 queue에서 현재 Node 좌표를 뽑는다.
 *  2.6 8방향 탐색을 위해 for(i++ < 8) 까지 반복문을 수행한다.
 *  2.6.1 nextRow 와 nextCol을 구하고 validate() 로 map.length 와 map[0].length 안에서문 수행하도록 조건식을 추가한다.
 *  2.6.2 if(!visited) 인경우에 queue에 nextRow와 nextCol을 담고 visited 방문처리한다.
 *  2.7 while 문이 끝나면 1을 반환한다.
 *
 * 3. 출력
 *  3.1 각 테스트 케이스 별로 sum을 bfs StringBuilder에 담는다.
 *  3.2. 0 0 입력되는 경우 StringBuilder를 출력한다.
 */
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int[] dirRow = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dirCol = {-1, 0, 1, 1, 1, 0, -1, -1};
    static boolean[][] visited;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        while (true) {
            String inputData = br.readLine();
            if (inputData.equals("0 0")) { // 종료조건
                break;
            }

            String[] mapSize = inputData.split(" ");
            int n = Integer.parseInt(mapSize[1]);
            int m = Integer.parseInt(mapSize[0]);

            map = new int[n][m];
            visited = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                String[] mapInfo = br.readLine().split(" ");
                for (int j = 0; j < m; j++) {
                    map[i][j] = Integer.parseInt(mapInfo[j]);
                }
            }

            // 2중 For문을 돌며 랜드 확인
            int sum = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!visited[i][j] && map[i][j] == 1) {
                        sum += bfs(i, j);

                    }
                }
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb.toString());
    }

    static int bfs(int startRow, int startCol) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startRow, startCol});
        visited[startRow][startCol]= true;

        while (!queue.isEmpty()) {
            int[] nowLocation = queue.poll();
            int nowRow = nowLocation[0];
            int nowCol = nowLocation[1];

            for (int i = 0; i < 8; i++) {
                int nextRow = dirRow[i] + nowRow;
                int nextCol = dirCol[i] + nowCol;

                if (validate(nextRow, nextCol)) {
                    if (!visited[nextRow][nextCol] && map[nextRow][nextCol] == 1) {
                        queue.add(new int[]{nextRow, nextCol});
                        visited[nextRow][nextCol] = true;
                    }
                }
            }
        }

        return 1;
    }

    static boolean validate(int row, int col) {
        return row >= 0 && col >= 0 && row < map.length && col < map[0].length;
    }

}

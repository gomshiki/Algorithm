import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 입력
 * 1.1 맵 크기 M, N : M 은 행 크기, N 은 열 크기
 * 1.2.1 맵 정보 : 0 => 통과 O
 * 1.2.2 맵 정보 : 1 => 통과 X
 * <p>
 * 2. 풀이
 * 2.1 상하좌우 탐색을 위해 4방향 배열선언
 * 2.2 outer side 에서 탐색을 시작해야함
 * 2.2.1 for(i++ < N) 중 map[row][col] == 0일 경우와 !visited[row][col] 일 경우 bfs 시작
 * 2.4 static boolean bfs(int row, int col) 메서드 선언
 * 2.4.1 bfs 시작 지점 방문 처리민 queue 에 저장
 * 2.5.0 큐가 빌때까지 while 문 반복
 * 2.5.1 queue.poll 로 현재 위치를 빼고 4방향 탐색을 위해 for(i++ < 4) 수행
 * 2.5.0 inner side에 방문했을 경우에 true 를 반환 하고 bfs 종료
 * 2.5.0.2 nowRow == M - 1 조건 추가
 * 2.6.1 if(!validate) 배열 크기 안에서만 수행
 * 2.6.2 if(!visited[nextRow][nextCol]) 방문하지 않았을 경우
 * 2.6.3 if(map[nextRow][nextCol] == 0 ) 일 경우
 * 2.6.4 queue에 다음 좌표 저장 및 방문처리
 * 2.7 bfs 결과가 true 면 StringBuilder에 "YES" 담기
 * 2.8 for문 다돌때까지 true가 없으면 StringBuilder에 "NO" 담기
 * <p>
 * 3. 출력
 * 3.1 StringBuilder 출력
 */
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int[][] map;
    static int[] dirRow = {-1, 0, 1, 0};
    static int[] dirCol = {0, 1, 0, -1};
    static int n, m;
    static boolean[][] visited;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken()); // 행 크기
        n = Integer.parseInt(st.nextToken()); // 열 크기

        map = new int[m][n];
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            String[] mapInfo = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(mapInfo[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            if (!visited[0][i] && map[0][i] == 0) {
                if (bfs(0, i)) {
                    System.out.println("YES");
                    return;
                }
            }
        }
        System.out.println("NO");
    }

    static boolean bfs(int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});
        visited[row][col] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int nowRow = poll[0];
            int nowCol = poll[1];

            if (nowRow == m - 1) {
                return true;
            }

            for (int i = 0; i < 4; i++) {
                int nextRow = nowRow + dirRow[i];
                int nextCol = nowCol + dirCol[i];
                if (validate(nextRow, nextCol)) {
                    if (!visited[nextRow][nextCol] && map[nextRow][nextCol] == 0) {
                        queue.add(new int[]{nextRow, nextCol});
                        visited[nextRow][nextCol] = true;
                    }
                }
            }
        }
        return false;
    }

    static boolean validate(int row, int col) {
        return row >= 0 && col >= 0 && row < m && col < n;
    }
}

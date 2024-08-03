import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 입력
 *  1.1  캠퍼스 크기 N x M
 *  1.2 맵정보
 *  1.2.1   0 : 빈공간
 *          x : 벽
 *          I : 도연이 => 번만주어짐
 *          P : 사람
 *
 * 2. 문제풀이
 *  2.1 캠퍼스내에서 상하좌우로만 이동 => 4방탐색 int[] dirRow, dirCol 을 static으로 초기화한다.
 *  2.2 맵정보는 char[][] 배열로 받는다
 *  2.3 2중 for 문을 돌며 if 조건식으로 I(도연이)를 찾는 순간 bfs에 해당 좌표를 넘겨 bfs를 수행한다.
 *  2.3.1 재방문을 방지하기위 boolean[N][M] visited 배열을 초기화한다.
 *  2.4.0.bfs의 반환 타입은 int로 한다.
 *  2.4.1 bfs에선 int[] 배열 타입으로 Queue를 생성한다.
 *  2.4.2 queue에 시작점 좌표 row, col을 담는다.
 *  2.4.3 시작점 좌표 visited[row][col] = true 로 방문처리한다.
 *  2.4.4 사람인원을 담기위한 int cnt = 0 를 초기화한다.
 *  2.5.1 while(!queue.isEmpty())로 queue가 빌때까지 bfs를 수행한다.
 *  2.5.2 queue에서 현재 좌표 Row, col 을 꺼낸다.
 *  2.6 4방향 탐색을 위해 for ( i++ < 4) 문을 수행한다.
 *  2.6.1 현재 Row + dir[i] = nextRow, col + dirCol[i] = nextCol 로 다음 좌표를 구한다.
 *  2.6.2 nextCol & nextRow 는 0 이상이여하고 N과 M 보다 작아야한다. => validate 함수선언
 *  2.6.3 nextCol & nextRow 는 이미 방문한곳은 재방문할수 없기에 !visited[nextRow][nextCol] 이어야함
 *  2.6.4 조건식을 2개 별도로 설정하는데 map[nextRow][nextCol] == '0'인 경우와 =='P'일떄로 나눈다.
 *  2.6.5.1 map[nextRow][nextCol] =='0' 인경우 => visited[nextRow][nextCol] true(방문처리) 및 queue.add(new int[]{nextRow, nextCol}
 *  2.6.5.2 map[nextRow][nextCol] == 'P' 인경우 => 2.9.5.1과 동일수행하고 cnt += 1 해서 만난사람을 더해준다.
 *  2.7 while 문바깥에 return cnt 한다.
 *
 *
 * 3. 출력
 *  3.1.1 2.3 2중 for문 안에서 bfs 결과가 0이면 sb.append("TT") 담고 break
 *  3.1.2 결과가 0보다 크면 sb.append(bfs(i,j)) 담고 break
 *  3.2 Stringbuilder를 출력하고 종료
 *
 */
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M;
    static char[][] map;
    static boolean[][] visited;
    static int[] dirRow = {0, -1, 0, 1};
    static int[] dirCol = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        // 2.3 'I'를 찾기위한 2중 For문 수행
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'I') {
                    int result = bfs(i, j);
                    sb.append(result > 0 ? result : "TT");
                    break;
                }
            }
        }
        System.out.println(sb.toString());
    }

    static int bfs(int startRow, int startCol) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startRow, startCol});
        visited[startRow][startCol] = true;

        // 만난 사람의 횟수
        int cnt = 0;
        while (!queue.isEmpty()) {
            int[] nowLocation = queue.poll();
            int nowRow = nowLocation[0];
            int nowCol = nowLocation[1];

            for (int i = 0; i < 4; i++) {
                int nextRow = nowRow + dirRow[i];
                int nextCol = nowCol + dirCol[i];

                if(validate(nextRow, nextCol)){
                    if (!visited[nextRow][nextCol]) {
                        if (map[nextRow][nextCol] == 'O') {
                            queue.add(new int[]{nextRow, nextCol});
                            visited[nextRow][nextCol] = true;
                        }
                        if (map[nextRow][nextCol] == 'P') {
                            queue.add(new int[]{nextRow, nextCol});
                            visited[nextRow][nextCol] = true;
                            cnt += 1;
                        }

                    }
                }
            }
        }

        return cnt;
    }

    static boolean validate(int row, int col) {
        return row >= 0 && col >= 0 && row < N && col < M;
    }
}

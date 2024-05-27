import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
				// 입력데이터 받기
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;


        while (true) {
     				// 덩어리 갯수를 체크 : 덩어리가 없거나, 2개 이상이면 break;
            if (bfsCnt(map) == 0) {
                answer = 0;
                break;
            }
            if (bfsCnt(map) >= 2) {
                break;
            }
            
            // 빙산 덩어리가 1개라면 bfs()로 빙산 녹이기
            bfs();
            
            // 횟수 count
            answer++;
        }
        System.out.println(answer);

    }


    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 0) {
                    q.offer(new int[]{i, j});
                    visit[i][j] = true;
                }
            }
        }
			
        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int x = temp[0];
            int y = temp[1];

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (visit[nx][ny]) continue;
                
                // 4방향이 0값을 갖을경우
                if (map[nx][ny] == 0) {
		                // 빙산이 0보다 큰 양수일때
                    if (map[x][y] > 0)
												// 빙산 녹이기
                        map[x][y]--;
                }

            }
        }
    }

		// 덩어리 갯수 확인
    static int bfsCnt(int[][] maps) {
    
        int ans = 0;
        
        // 방문 체크를 위한 boolean 배열 선언
        boolean[][] chk = new boolean[n][m];

        Queue<int[]> queue = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
            
		            // 빙하의 높이가 0보다 큰 양수이고, 방문하지 않은경우
                if (maps[i][j] != 0 && !chk[i][j]) {
                
		                // queue에 해당 좌표를 넣고
                    queue.offer(new int[]{i, j});
										
										// queue 가 빌때까지 반복 : 연결되어있는 모든 빙산을 방문할때까지
                    while (!queue.isEmpty()) { 
                    
		                    // queue에서 꺼내
                        int[] tmp = queue.poll();
                        int tx = tmp[0];
                        int ty = tmp[1];

                        for (int d = 0; d < 4; d++) {
                        
		                        // 4방향을 검사하고
                            int nx = tx + dx[d];
                            int ny = ty + dy[d];

                            if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                            if (maps[nx][ny] == 0 || chk[nx][ny]) continue;
                            
                            // 4방향의 빙하가 0이 아니고, 방문하지 않은경우
                            // queue 에 넣고
                            queue.offer(new int[]{nx, ny});
                            
                            // 방문 처리를 한다.
                            chk[nx][ny] = true;
                        }
                    }
                    // 연결되어있는 빙산 갯수 1개씩 더하기
                    ans++;
                }
            }
        }

				// 전체 빙산 덩어리 갯수 반환
        return ans;
    }
}
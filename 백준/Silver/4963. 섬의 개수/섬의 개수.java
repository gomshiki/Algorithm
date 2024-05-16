import java.io.*;
import java.util.*;

public class Main {

    static int[][] map;
    static boolean[][] visited;
    static StringBuilder sb = new StringBuilder();

    // 4방향 + 대각선 = 8 방향
    static int dirRow[] = {0, 0, -1 ,1, -1, 1, -1, 1}; // 상 하 좌 우 대각선 상좌, 상우, 하좌, 하우
    static int dirCol[] = {-1, 1, 0, 0, 1, 1, -1, -1}; // 상 하 좌 우 대각선 상좌, 상우, 하좌, 하우


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String str = " ";
        while (!(str = br.readLine()).equals("0 0")) {
            String[] split = str.split(" ");
            int w = Integer.parseInt(split[0]); // 너비
            int h = Integer.parseInt(split[1]); // 높이


            map = new int[h][w]; // 지도 크기
            visited = new boolean[h][w]; // 방문 여부

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int answer = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {

                    if(!visited[i][j] && map[i][j] == 1) {
                        answer  = answer + bfs(i,j);
                    }
                }
            }

            sb.append(answer).append("\n");
        }

        System.out.print(sb);

    }

    static int bfs(int col, int row) {

        Queue<int[]> queue = new LinkedList<>();
        visited[col][row] = true;
        queue.add(new int[]{col, row});

        while (!queue.isEmpty()) {

            int[] poll = queue.poll();
            int nowCol = poll[0];
            int nowRow = poll[1];

            // 8방향 검사
            for (int i = 0; i < 8; i++) {
                int nextRow = nowRow + dirRow[i];
                int nextCol = nowCol + dirCol[i];

                if(nextCol >= 0 && nextRow >= 0 && nextRow < map[0].length && nextCol < map.length) {
                    if(!visited[nextCol][nextRow] && map[nextCol][nextRow] == 1) {
                        visited[nextCol][nextRow] = true;
                        queue.add(new int[]{nextCol, nextRow});
                    }
                }
            }

        }
        return 1;
    }
}

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static Queue<int[][]> queue = new LinkedList<>();
    static boolean[][] visited;
    static int[][] map;
    static int[] dirRow = {1, 0, -1, 0};
    static int[] dirCol = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // 테스트 케이스
        int T = Integer.parseInt(br.readLine());

        // 테스트 케이스 반복
        for (int t = 0; t < T; t++) {

            // 가로길이 M, 세로길이 N, 배추 위치 개수 K
            String[] str = br.readLine().split(" ");

            int M = Integer.parseInt(str[0]);
            int N = Integer.parseInt(str[1]);
            int K = Integer.parseInt(str[2]);

            map = new int[N][M];

            for (int i = 0; i < K; i++) {
                String[] inputs = br.readLine().split(" ");
                int column = Integer.parseInt(inputs[0]);
                int row = Integer.parseInt(inputs[1]);
                map[row][column] = 1;
            }

            visited = new boolean[N][M];

            int answer = 0;


            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[0].length; j++) {
                    if(map[i][j] == 1) {
                        answer = answer + bfs(i, j);
                    }
                }
            }

            sb.append(answer).append("\n");
        }
        System.out.println(sb.toString());
    }

    static int bfs(int startRow, int startCol) {
        // 조사한 지점이면 bfs 종료
        if (visited[startRow][startCol] == true) {
            return 0;
        }

        // 조사하지 않은 곳이면 체크
        visited[startRow][startCol] = true;

        int[][] firstPosition = {{startRow, startCol}};
        queue.add(firstPosition);

        int count = 0;

        while (!queue.isEmpty()) {

            int[][] peek = queue.poll();
            int nowRow = peek[0][0];
            int nowCol = peek[0][1];

            // 4방향 검사
            for (int i = 0; i < 4; i++) {

                int nextRow = nowRow + dirRow[i];
                int nextCol = nowCol + dirCol[i];

                if (nextRow >= 0 && nextCol >= 0 && nextRow < map.length && nextCol < map[0].length) {

                    if (map[nextRow][nextCol] == 1 && !visited[nextRow][nextCol]) {

                        int[][] nextPosition = {{nextRow, nextCol}};
                        queue.add(nextPosition);
                        visited[nextRow][nextCol] = true;
                        count++;
                    }
                }
            }
        }

        return count >= 0 ? 1 : 0;
    }
}

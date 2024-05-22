import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static boolean[][][] visited;
    static char[][][] map;
    static int[][][] timeTable;
    static Queue<int[]> queue = new LinkedList<>();
    static int[] dirRow = {0, 0, 1, 0, -1, 0};
    static int[] dirColumn = {0, 0, 0, -1, 0, 1};
    static int[] dirLaywer = {1, -1, 0, 0, 0, 0};
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String inputString = br.readLine();

            StringTokenizer st = new StringTokenizer(inputString);

            // 층
            int layer = Integer.parseInt(st.nextToken());
            // 행
            int row = Integer.parseInt(st.nextToken());
            // 열
            int column = Integer.parseInt(st.nextToken());

            if (layer == 0 && row == 0 && column == 0) {
                break;
            }

            visited = new boolean[layer][row][column];
            map = new char[layer][row][column];
            timeTable = new int[layer][row][column];

            int[] startPosition = new int[3];
            int[] endPosition = new int[3];

            for (int i = 0; i < layer; i++) {
                for (int j = 0; j < row + 1; j++) {
                    String inputRow = br.readLine();

                    if (!inputRow.isEmpty()) {
                        for (int k = 0; k < column; k++) {
                            map[i][j][k] = inputRow.charAt(k);
                            if (map[i][j][k] == 'S') {
                                startPosition = new int[]{i, j, k};
                            }

                            if (map[i][j][k] == 'E') {
                                endPosition = new int[]{i, j, k};
                            }
                        }
                    }
                }
            }

            bfs(startPosition, endPosition);
        }

        System.out.println(sb.toString());

    }

    static void bfs(int[] startPosition, int[] endPosition) {
        // 검증 로직
        queue.add(startPosition);

        while (!queue.isEmpty()) {

            int[] nowPosition = queue.poll();

            int nowLayer = nowPosition[0];
            int nowRow = nowPosition[1];
            int nowColumn = nowPosition[2];
//            System.out.println("nowDimension = " + nowLayer + ", " + nowRow + ", " + nowColumn);

            if (map[nowLayer][nowRow][nowColumn] == 'E') {
                sb.append("Escaped in ").append(timeTable[nowLayer][nowRow][nowColumn]).append(" minute(s).\n");
                queue.clear();
                break;
            }


            for (int i = 0; i < 6; i++) {
                int nextLayer = nowLayer + dirLaywer[i];
                int nextRow = nowRow + dirRow[i];
                int nextColumn = nowColumn + dirColumn[i];

                if (boundaryCheck(nextLayer, nextRow, nextColumn)) {
                    if (!visited[nextLayer][nextRow][nextColumn]) {

                        if (map[nextLayer][nextRow][nextColumn] == '.' || map[nextLayer][nextRow][nextColumn] == 'E') {

                            visited[nextLayer][nextRow][nextColumn] = true;
                            queue.add(new int[]{nextLayer, nextRow, nextColumn});
                            timeTable[nextLayer][nextRow][nextColumn] = timeTable[nowLayer][nowRow][nowColumn] + 1;

                        }
                    }
                }
            }
        }
        if (timeTable[endPosition[0]][endPosition[1]][endPosition[2]] == 0) {
            sb.append("Trapped!").append("\n");
        }

    }

    static boolean boundaryCheck(int nextLayer, int nextRow, int nextColumn) {

        if (nextLayer >= 0 && nextRow >= 0 && nextColumn >= 0) {
            if (nextLayer < map.length && nextRow < map[0].length && nextColumn < map[0][0].length) {
                return true;
            }
        }
        return false;
    }
}

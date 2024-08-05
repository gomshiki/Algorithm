import java.util.*;
import java.io.*;

public class Main {

    static char[][] map;
    static Queue<int[]> queue = new LinkedList<>();
    static int[] dirRow = {-1, 0, 1, 0};
    static int[] dirColumn = {0, 1, 0, -1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        map = new char[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {

            String inputData = br.readLine();

            for (int j = 0; j < N; j++) {
                map[i][j] = inputData.charAt(j);

            }
        }

        int redCount = 0;
        int greenCount = 0;
        int blueCount = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    if (map[i][j] == 'R') {
                        redCount += bfs(i, j, new char[]{'R'});
                    }
                    if (map[i][j] == 'G') {
                        greenCount += bfs(i, j, new char[]{'G'});
                    }
                    if (map[i][j] == 'B') {
                        blueCount += bfs(i, j, new char[]{'B'});
                    }
                }

            }
        }
        int answer1 = redCount + greenCount + blueCount;

        int answer2 = 0;
        int redGreenCount = 0;
        int blueCount2 = 0;

        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    if (map[i][j] == 'R' || map[i][j] == 'G') {
                        redGreenCount += bfs(i, j, new char[]{'R', 'G'});
                    }
                    if (map[i][j] == 'B') {
                        blueCount2 += bfs(i, j, new char[]{'B'});
                    }
                }

            }
        }
        answer2 = redGreenCount + blueCount2;

        System.out.println(answer1 + " " + answer2);

    }

    static int bfs(int firstRow, int firstColumn, char[] targetChars) {

        queue.add(new int[]{firstRow, firstColumn});
        while (!queue.isEmpty()) {
            int[] nowNode = queue.poll();
            int nowRow = nowNode[0];
            int nowColumn = nowNode[1];

            for (int i = 0; i < 4; i++) {
                int nextRow = dirRow[i] + nowRow;
                int nextColumn = dirColumn[i] + nowColumn;

                if (checkBoundary(nextRow, nextColumn) && !visited[nextRow][nextColumn]) {

                    for (char targetChar : targetChars) {
                        if (map[nextRow][nextColumn] == targetChar) {
                            visited[nextRow][nextColumn] = true; // 방문 처리
                            queue.add(new int[]{nextRow, nextColumn});
                        }
                    }

                }

            }

        }

        return 1;

    }

    static boolean checkBoundary(int nextRow, int nextColumn) {

        return nextRow >= 0 && nextColumn >= 0 && nextRow < map.length && nextColumn < map[0].length;
    }

}

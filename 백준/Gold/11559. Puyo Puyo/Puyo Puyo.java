import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    static char[][] map = new char[12][6];
    static boolean[][] visited;
    static int[] dirRow = {-1, 0, 1, 0};
    static int[] dirColumn = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 12; i++) {

            String s = br.readLine();
            for (int j = 0; j < 6; j++) {
                map[i][j] = s.charAt(j);
            }
        }


        int cnt = 0;
        boolean recap = false;
        while(true) {
            visited = new boolean[12][6];
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (map[i][j] != '.' && !visited[i][j]) {
                        int result = bfs(i, j);
                        if (result > 0) {
                            recap = true;
                        }
                    }
                }
            }
            if(recap){
                cnt++;
                movePuyo();
                recap = false;
            }else{
                sb.append(cnt);
                break;
            }
        }
        System.out.println(sb.toString());
    }

    private static void movePuyo() {
        Queue<Character> colorQueue = new LinkedList<>();

        for (int i = 0; i < 6; i++) {

            for (int j = 11; j >= 0; j--) {
                if (map[j][i] != '.') {
                    colorQueue.add(map[j][i]);
                    map[j][i] = '.';

                }
            }

            if (colorQueue.isEmpty()) continue;

            int cnt = colorQueue.size();
            for (int j = 0; j < cnt; j++) {
                map[11 - j][i] = colorQueue.poll();
            }

        }
    }


    static int bfs(int row, int column) {
        List<int[]> list = new LinkedList<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, column});
        int colourCnt = 0;

        int result = 0;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int nowRow = poll[0];
            int nowColumn = poll[1];

            for (int i = 0; i < 4; i++) {
                int nextRow = nowRow + dirRow[i];
                int nextColumn = nowColumn + dirColumn[i];

                if (validate(nextRow, nextColumn) && !visited[nextRow][nextColumn]) {
                    if (map[nextRow][nextColumn] != '.' && map[nextRow][nextColumn] == map[nowRow][nowColumn]) {
                        int[] nextNode = {nextRow, nextColumn};
                        list.add(nextNode);
                        queue.add(nextNode);
                        visited[nextRow][nextColumn] = true;
                        colourCnt++;

                    }
                }
            }
        }

        if (colourCnt >= 4) {
            for (int[] targetNode : list) {
                int targetRow = targetNode[0];
                int targetColumn = targetNode[1];
                map[targetRow][targetColumn] = '.';
            }
            result++;

        }
        return result;

    }

    static boolean validate(int nextRow, int nextColumn) {
        return nextRow >= 0 && nextColumn >= 0 && nextRow < 12 && nextColumn < 6;
    }

}

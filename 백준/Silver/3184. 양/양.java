import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 1. 입력
 * 1.1 마당 크기 RxC
 * 1.2 마당 정보
 * 1.2.1 '.' 빈공간 | '#' 울타리 | 'o' 양 | 'v' 늑대
 * <p>
 * 2. 풀이
 * 2.1 이동은 상하좌우, 울타리 안은 같은 공간으로 간주
 * 2.2 같은 공간(울타리안)에 양의 수가 늑대보다 많으면 이기고, 양의 수가 늑대와 같거나 적다면 잡아먹힘
 * 2.3.0 map 탐색을 위해 2중 for문 반복
 * 2.3.1 if map[i][j] == 'v', 'o' 늑대나 양이면 bfs 수행
 * 2.4 bfs를 수행 시 'o', 'v' 늑대와 양의 마리 수 합계를 구하고 크기를 비교한다.
 * 2.4.1 양 마리수 > 늑대 마리 수 : Map<Character, Integer> 에 map.put('o', map.get('o') + 양의 마리수)
 * 2.4.2 양 마리수 <= 늑대 마리수 :  map.put('v', map.get('v') + 늑대 마리수)
 * <p>
 * 3. 출력
 * 3.1 map 을 출력
 */
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static Map<Character, Integer> answer = new HashMap<>();
    static StringTokenizer st;
    static char[][] map;
    static boolean[][] visited;
    static int n, m;
    static int[] dirRow = {-1, 0, 1, 0};
    static int[] dirCol = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        answer.put('v', 0);
        answer.put('o', 0);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && map[i][j] == 'v' ) {
                    bfs(i, j);
                }
                if(!visited[i][j] &&  map[i][j] == 'o'){
                    bfs(i, j);
                }
            }
        }

        System.out.println(answer.get('o') + " " + answer.get('v'));

    }

    static void bfs(int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});
        visited[row][col] = true;

        int sheep = 0;
        int wolf = 0;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int nowRow = poll[0];
            int nowCol = poll[1];

            if (map[nowRow][nowCol] == 'o') sheep += 1;
            if (map[nowRow][nowCol] == 'v') wolf += 1;

            for (int i = 0; i < 4; i++) {
                int nextRow = nowRow + dirRow[i];
                int nextCol = nowCol + dirCol[i];

                if (validate(nextRow, nextCol)) {
                    if (!visited[nextRow][nextCol] && map[nextRow][nextCol] != '#') {
                        queue.add(new int[]{nextRow, nextCol});
                        visited[nextRow][nextCol] = true;
                    }
                }
            }
        }
        if (sheep > wolf) { // 양이 많을 경우
            answer.put('o', answer.get('o') + sheep);
        } else { // 늑대가 많거나 양과 같을 경우
            answer.put('v', answer.get('v') + wolf);
        }
    }

    static boolean validate(int row, int col) {
        return row >= 0 && col >= 0 && row < n && col < m;
    }


}

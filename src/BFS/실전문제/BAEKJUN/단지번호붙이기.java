package BFS.실전문제.BAEKJUN;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 단지번호붙이기 {

    /**
     * <그림 1>과 같이 정사각형 모양의 지도가 있다.
     * 1은 집이 있는 곳을, 0은 집이 없는 곳을 나타낸다. 철수는 이 지도를 가지고 연결된 집의 모임인 단지를 정의하고, 단지에 번호를 붙이려 한다.
     * 여기서 연결되었다는 것은 어떤 집이 좌우, 혹은 아래위로 다른 집이 있는 경우를 말한다. 대각선상에 집이 있는 경우는 연결된 것이 아니다.
     * <그림 2>는 <그림 1>을 단지별로 번호를 붙인 것이다. 지도를 입력하여 단지수를 출력하고,
     * 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력하는 프로그램을 작성하시오.
     *
     * 입력
     * 7
     * 0110100
     * 0110101
     * 1110101
     * 0000111
     * 0100000
     * 0111110
     * 0111000
     *
     * 출력
     * 3
     * 7
     * 8
     * 9
     */

    static int[][] grid;
    static StringBuilder sb = new StringBuilder();

    static boolean[][] visited;

    static int[] directionX = {1, 0, -1, 0};
    static int[] directionY = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {



        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int lineCount = Integer.parseInt(br.readLine());

        grid = new int[lineCount + 1][lineCount + 1];

        for (int i = 1; i < grid.length; i++) {

            String[] s = br.readLine().split("");

            for (int j = 1; j < grid.length; j++) {
                grid[i][j] = Integer.parseInt(s[j-1]);
            }
        }

        System.out.println(Arrays.deepToString(grid));


    }

    // BFS 함수 정의
    static void bfs() {

        Queue<int[]> queue = new LinkedList<>();

        int startNodeX = 1;
        int startNodeY = 1;

        queue.offer(new int[]{startNodeY, startNodeX});

        while (!queue.isEmpty()) {


            for (int i = 1; i <= 4; i++) {


                int[] currentNode = queue.poll();



                int currentY = currentNode[0];
                int currentX = currentNode[1];

                int nextX = directionX[i] + currentX;
                int nextY = directionY[i] + currentY;

                if (nextX < 0 || nextY < 0 || nextX > grid[0].length || nextX > grid.length) {
                    continue;
                }

                if (grid[nextY][nextX]==1 && !visited[nextY][nextX]) {

                    queue.offer(new int[]{nextY, nextX});
                    visited[currentY][currentX] = true;

                }


            }



        }

    }
}

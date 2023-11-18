package BFS.실전문제.BAEKJUN;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class 미로탐색 {


    static int[][] grid;

    static int[] directionX = {1, 0, -1, 0};
    static int[] directionY = {0, 1, 0, -1};

    static boolean[][] visited;
    public static void main(String[] args) throws IOException {

        /**
         * 미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다. 이러한 미로가 주어졌을 때,
         * (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오.
         * 한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동할 수 있다.
         *
         * 입력
         * 4 6 // 두 정 수 N, M
         * 101111 // 미로 데이터
         * 101010
         * 101011
         * 111011
         *
         * 출력 // 1,1 부터 n,m 까지 갈 때 최소 칸의 수 출력
         * 15
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        grid = new int[N + 1][M + 1];

        // 입력받은 문자열을 2차원 int 배열로 변환하기
        for (int i = 0; i < N; i++) {

            String[] s = br.readLine().split(""); // 입력받은 문자열을 한개씩 잘라 문자열배열로
            int[] row = Stream.of(s).mapToInt(Integer::parseInt).toArray(); // 문자열배열을 int[] 배열로
            grid[i] = row; // int[] 배열을 선언된 grid[][] 에 할당

        }

        System.out.println(Arrays.deepToString(grid)); // 출력 테스트











    }

    static void bfs(){

        Queue<int[][]> q = new LinkedList<>();

        q. offer(new int[1][1]);


        while (!q.isEmpty()) {

            int[][] currentNode = q.poll(); // 1,1 = 1

            int startX = 1;
            int startY = 1;

            for (int i = 0; i < 4; i++) {

                int nextX = startX + directionX[i];
                int nextY = startY + directionY[i];

                if (nextX < 0 || nextY < 0) {
                    continue;
                }

            }

        /*    for (int i = 0; i < ; i++) {

                if (grid[][] && !visited[][]) {
                    visited[][] = true;
                    q.offer()
                }

            }*/

        }

    };
}

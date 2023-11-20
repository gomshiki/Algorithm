package BFS.실전문제.BAEKJUN;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
     static ArrayList<Integer> minDistance = new ArrayList<>();

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

        grid = new int[N][M];
        visited = new boolean[N][M];

        // 입력받은 문자열을 2차원 int 배열로 변환하기
        for (int i = 0; i < N; i++) {

            String[] s = br.readLine().split(""); // 입력받은 문자열을 한개씩 잘라 문자열배열로
            int[] row = Stream.of(s).mapToInt(Integer::parseInt).toArray(); // 문자열배열을 int[] 배열로
            grid[i] = row; // int[] 배열을 선언된 grid[][] 에 할당

        }

        bfs();


        int min = minDistance.get(0);
        for (int i = 1; i < minDistance.size(); i++) {

            if (min > minDistance.get(i)) {
                min = minDistance.get(i);
            }

        }

        System.out.println("min = " + min);

    }

    static void bfs(){

        Queue<int[][]> q = new LinkedList<>();

        int[][] startNode = new int[][]{{0, 0}};

        // 첫번째 노드 방문처리
        visited[0][0] = true;
        q.offer(startNode);

        while (!q.isEmpty()) {

            System.out.println("********* while문 시작 **********");

            int[][] currentNode = q.poll(); // 0,0 = 1
            System.out.println("currentNode = " + Arrays.deepToString(currentNode));

            // 4 방향 확인
            for (int i = 0; i < 4; i++) {
                System.out.println(" =========================== for문 시작 ========================");
                System.out.println(i+"번째 출력");

                int currentX = currentNode[0][1];
                int currentY = currentNode[0][0];

                System.out.println("currentY = " + currentY);
                System.out.println("currentX = " + currentX);


                int nextNodeX = currentX + directionX[i]; // 1, 0, -1, 0
                int nextNodeY = currentY + directionY[i]; // 0, 1, 0, -1

                System.out.println("nextNodeY = " + nextNodeY);
                System.out.println("nextNodeX = " + nextNodeX);

                // 현재 노드 기준
                // 남쪽 grid[1][0] = 1,               동쪽 grid[0][1] = 0
                // 북쪽 gird[-1][0] = outOfIndex,     서쪽 grid[0][-1] = outOfIndex

                // 옆이 벽면일 경우 제외
                if (nextNodeX < 0 || nextNodeY < 0 || nextNodeX > grid[0].length - 1 || nextNodeY > grid.length - 1 ) {
                    System.out.println("@@@ 옆면이 벽면임 @@@︎︎︎");
                    continue;

                }

                System.out.println("grid[nextNodeY][nextNodeX] = " + grid[nextNodeY][nextNodeX]);
                // i=0, nextX = 1, nextY = 0

                /**
                 *  101111 // 미로 데이터
                 *  101010
                 *  101011
                 *  111011
                 */
                if (grid[nextNodeY][nextNodeX] == 1 && !visited[nextNodeY][nextNodeX]) {
                    System.out.println("----------"+i+"번째 큐에 넣는 조건 검사중!!----------");
                    System.out.println("nextNodeY = " + nextNodeY);
                    System.out.println("nextNodeX = " + nextNodeX);

                    System.out.println("grid[0].length = " + grid[0].length);
                    System.out.println("grid.length = " + grid.length);

                    // 목표 노드에 도착했을 때
                    if (nextNodeX == grid[0].length-1 && nextNodeY == grid.length-1 ) {
                        System.out.println("** last grid[currentY][currentX] = " + (grid[currentY][currentX] + 1));
                        minDistance.add((grid[currentY][currentX] + 1));
                        continue;
                    }

                    grid[nextNodeY][nextNodeX] = grid[currentY][currentX] + 1;
                    q.offer(new int[][]{{nextNodeY, nextNodeX}});

                    System.out.println("q에 nextNode 닮긴값 ==> ["+nextNodeY+"]["+nextNodeX+"]" );
                    visited[currentY][currentX] = true;
                }

                System.out.println(" R=========================== for문 종료 ========================");
                System.out.println();
            }

            System.out.println("********* while문 진행 중  **********");
            System.out.println();

        }

        System.out.println("********* while문 종료 **********");


    };
}

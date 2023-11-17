package BFS.실전문제.BAEKJUN;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로탐색 {


    static int[][] graph;

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

        graph = new int[N+1][M+1]; // 4x6 행렬

        for (int i = 1; i < N+1; i++) {

            String[] s = br.readLine().split("");

            for (int j = 1; j < M+1; j++) {

                graph[i][j] = Integer.parseInt(s[j-1]);
                System.out.println("graph["+i+"]["+j+"] = " + graph[i][j]);

            }

        }

        bfs();











    }

    static void bfs(){

        Queue<int[][]> q = new LinkedList<>();

        q. offer(new int[1][1]);


        while (!q.isEmpty()) {

            int[][] currentNode = q.poll();

            for (int i = 0; i < ; i++) {

                if (visited) {
                    visited[][] = true;
                    q.offer()
                }

            }

        }

    };
}

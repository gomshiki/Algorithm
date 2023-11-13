package BFS.실전문제.BAEKJUN;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DFSAndBFS {


    /**
     * 문제
     * 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오.
     * 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고,
     * 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.
     *
     * 첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다.
     * 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다.
     * 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다.
     * 입력으로 주어지는 간선은 양방향이다.
     *
     * 입력 예시
     * 4 5 1 (정점 개수, 간선 개수, 시작 정점의 번호)
     * 1 2   (1번 노드와 2번 노드 연결)
     * 1 3   (1번 노드와 3번 노드 연결)
     * 1 4   (1번 노드와 4번 노드 연결)
     * 2 4   (2번 노드와 4번 노드 연결)
     * 3 4   (3번 노드와 4번 노드 연결)
     *
     * 출력 예시
     * 1 2 4 3 // DFS
     * 1 2 3 4 // BFS
     */

    static StringBuilder sb = new StringBuilder();

    static int[][] treeArray;
    static boolean[] visited;
    static Queue<Integer> queue = new LinkedList<>();

    static int nodeCount, branchCount, startNode;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        nodeCount = Integer.parseInt(st.nextToken());
        branchCount = Integer.parseInt(st.nextToken());
        startNode = Integer.parseInt(st.nextToken());

        treeArray = new int[nodeCount + 1][nodeCount + 1];

        visited = new boolean[nodeCount + 1];

        for (int i = 0; i < branchCount; i++) {

            StringTokenizer st2 = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st2.nextToken());
            System.out.println("a = " + a);
            int b = Integer.parseInt(st2.nextToken());
            System.out.println("b = " + b);
            treeArray[a][b] = treeArray[b][a] = 1;
            System.out.println("treeArray[" + a + "][" + b + "] = " + treeArray[a][b]);

        }

        String bfs = bfs(startNode);

        System.out.println("bfs = " + bfs);
    }

    // bfs 포맷 정의
    static String bfs(int startNode) {

        // 시작노드 입력
        queue.offer(startNode);

        // 첫번째 노드 방문 처리
        visited[startNode] = true;


        // 큐가 빌때까지 반복
        while (!queue.isEmpty()) {

            // 큐안에 있는 값 빼기
            int currentNode = queue.poll();

            // StringBuilder에 저장
            sb.append(currentNode + " ");

            System.out.println("======================= 큐에서 뺀 노드 ======================");
            System.out.println("currentNode = " + currentNode);
            System.out.println();
            // 전체 노드 갯수 만큼 반복문
            for (int i = 1; i < nodeCount + 1; i++) {
                System.out.println("================================================================");
                System.out.println("treeArray[" + currentNode + "][" + i + "] = " + treeArray[currentNode][i]);
                System.out.println("visited[" + i + "] = " + !visited[i]);
                System.out.println("================================================================");

                // treeArray[currentNode][i] == 1 인 경우 && visited[i] 방문 안했을 경우
                if (treeArray[currentNode][i] == 1 && !visited[i]) {

                    // 그때 노드를 queue에 넣기
                    System.out.println("Queue에 넣는 노드index= " + i);
                    queue.add(i);
                    // 넣은 노드 방문처리
                    visited[i] = true;

                }


            }

        }




        return sb.toString();
    }

}

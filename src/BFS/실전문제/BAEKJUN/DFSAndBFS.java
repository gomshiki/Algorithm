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
     */

    public static void main(String[] args) throws IOException {

        // 값을 입력받을 버퍼리더 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력받은 버퍼르 토크나이저로 쪼개서 초기화
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 각 변수에 입력받은 값 선언
        int nodeCount = Integer.parseInt(st.nextToken());
        int branchCount = Integer.parseInt(st.nextToken());
        int startNode = Integer.parseInt(st.nextToken());

        int[][] visited = new int[nodeCount][branchCount];


        // 간선의 개수 만큼 간선 정보를 입력받음
        // 입력받은 String 데이터를 int[][] 배열로 !!
        int[][] graph = IntStream.range(0, branchCount)
                .mapToObj(
                        i -> {

                        try {
                            String[] s = br.readLine().split(" ");
                            return new int[]{Integer.parseInt(s[0]), Integer.parseInt(s[1])};

                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }

                    }
                ).toArray(int[][]::new);

        String result = bfs(graph, visited, startNode);

        System.out.println("result = " + result);

    }

    // bfs 포맷 정의
    static String bfs(int[][] graph, int[][] visited, int startNode) {

        StringBuilder sb = new StringBuilder();

        Queue<Integer> q = new LinkedList<>();

        // 시작점 입력
        q.offer(startNode);

        // 방문 처리
        visited[0][0] = 1;

        while (!q.isEmpty()) {

            int currentNode = q.remove();
            System.out.println("currentNode = " + currentNode);

            sb.append(currentNode + " ");

            for (int i = 0; i < graph[0].length; i++) {

                // 1, 2
                int temp = graph[currentNode][i];

                System.out.println("temp = " + temp);

                if(visited[temp][i] == 0){
                    visited[temp][i] = 1;
                    q.offer(temp);
                }
            }



        }
        return sb.toString();
    }

}

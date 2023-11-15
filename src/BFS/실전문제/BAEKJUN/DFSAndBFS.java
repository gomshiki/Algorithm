package BFS.실전문제.BAEKJUN;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFSAndBFS {


    /**
     * 문제 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을
     * 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.
     * <p>
     * 첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다. 다음 M개의 줄에는
     * 간선이 연결하는 두 정점의 번호가 주어진다. 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 입력으로 주어지는 간선은 양방향이다.
     * <p>
     * 입력 예시 4 5 1 (정점 개수, 간선 개수, 시작 정점의 번호) 1 2   (1번 노드와 2번 노드 연결) 1 3   (1번 노드와 3번 노드 연결) 1 4
     * (1번 노드와 4번 노드 연결) 2 4   (2번 노드와 4번 노드 연결) 3 4   (3번 노드와 4번 노드 연결)
     * <p>
     * 출력 예시 1 2 4 3 // DFS 1 2 3 4 // BFS
     * 4 5 1
     * 1 2
     * 1 3
     * 1 4
     * 2 4
     * 3 4
     */

    static Queue<Integer> q = new LinkedList<>();

    static int[][] graph;
    static boolean[] visited;

    static int node, branch, start;

    static StringBuilder sb = new StringBuilder();



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        node = Integer.parseInt(st.nextToken());
        branch = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        graph = new int[node + 1][node + 1];
        visited = new boolean[node + 1];

        for (int i = 0; i < branch; i++) {

            String[] s = br.readLine().split(" ");

            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);

            graph[a][b] = graph[b][a] = 1;
        }

        String bfs = bfs(start);
        System.out.println("bfs = " + bfs);

        // Stringbuilder 초기화
        sb.setLength(0);


        visited = new boolean[node + 1];
        String dfs = dfs(start);
        System.out.println("dfs = " + dfs);

    }

    static String bfs(int start){

        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {

            int currentNode = q.poll();


            sb.append(currentNode+" ");

            for (int i = 1; i <= node; i++) {

                if (graph[currentNode][i] == 1 && !visited[i]) {

                    q.offer(i);
                    visited[i] = true;
                }
            }
        }
        return sb.toString();
    }

    // 1 2 4 3
    static String dfs(int start) {

        visited[start] = true;

        // 방문한 노드에 인접한 노드 찾기
        for (int i = 1 ; i <= node; i++) {



            // 인접한 노드가 방문한 적이 없다면 DFS 수행
            if(graph[][] && !visited[node]){
                dfs(node);
            }
        }


        return sb.toString();
    }
}
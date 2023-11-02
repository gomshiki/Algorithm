package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class BFS00 {

    public static void main(String[] args) {
        // 그래프를 2차원 배열로 표현
        // 배열의 인덱스를 노드와 매칭시켜 사용하기위해 인덱스 0은 아무것도 저장하지 않음
        // 1번 인덱스는 1번 노드를 뜻하고 노드의 배열의 값은 연결된 노드임
        int[][] graph = {{}, {2,3,8}, {1,6,8}, {1,5}, {5,7}, {3,4,7}, {2}, {4,5}, {1,2}};

        // 방문처리를 위한 boolean배열 선언
        boolean[] visited = new boolean[9];

        // 시작노드는 1부터!
        int start = 1;

        System.out.println(bfs(start, graph, visited));

    }

    static String bfs(int start, int[][] graph, boolean[] visited) {
        // 탐색 순서를 출력하기 위한 용도
        StringBuilder sb = new StringBuilder();

        // BFS에 사용할 큐를 생성
        Queue<Integer> q = new LinkedList<>();

        // 큐에 BFS를 시작할 노드 번호를 넣어줌
        q.offer(start);

        // 시작노드를 방문처리
        visited[start] = true;

        // 큐가 빌 때까지 반복
        while (!q.isEmpty()) {

            // 큐에 담겨있는 노드를 꺼냄
            int nodeIndex = q.poll();

            // 꺼낸 코드를 sb에 저장!
            sb.append(nodeIndex + " ");

            // 큐에서 꺼낸 노드와 연결된 노드를 체크(연결된 노드 갯수만큼만 반복문 수행)
            for (int i = 0; i < graph[nodeIndex].length; i++) {
                // 연결된 노드를 꺼내 temp에 초기화
                int temp = graph[nodeIndex][i];

                // 해당 노드를 방문했는지 확인 방문하지 않았다면?
                if(!visited[temp]){

                    // 해당 노드를 방문처리
                    visited[temp] = true;

                    // 해당 노드를 q에 넣어줌
                    q.offer(temp);
                }

            }

        }
        // 탐색순서 리턴
        return sb.toString();

    }
}

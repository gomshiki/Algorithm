package DFS;

import java.util.Stack;

public class DFS_Stack {

    // 방문처리할 배열 선언
    static boolean[] visited = new boolean[9];

    // 그래프 연결 상태를 2차원 배열로 표현
    static int[][] graph = {{}, {2,3,8}, {1,6,8}, {1,5}, {5,7}, {3,4,7}, {2}, {4,5}, {1,2}};

    // DFS 사용할 스택 선언
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) {

        // 시작 노드를 스택에 넣어줌
        stack.push(1);

        // 시작노드 방문처리
        visited[1] = true;

        // 스택이 비어있지 않을때까지 반복
        while (!stack.isEmpty()) {

            // 스택 하나를 꺼냄
            int nodeIndex = stack.pop();

            // 방문 노드 출력
            System.out.print(nodeIndex + " ");

            // 꺼낸 노드와 인접한 노드 찾기
            for (int linkedNode : graph[nodeIndex]) {

                // 인접한 노드를 방문하지 않은경우 스택에 넣고 방문처리
                if (!visited[linkedNode]) {
                    stack.push(linkedNode);
                    visited[linkedNode] = true;
                }
            }
        }
    }

}

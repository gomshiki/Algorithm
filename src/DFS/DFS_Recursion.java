package DFS;

public class DFS_Recursion {

    // 방문 처리할 배열 선언
    static boolean[] visited = new boolean[9];

    // 그래프의 연결상태를 2차원 배열로 표현
    // 인덱스가 각 노드번호가 될 수 있게 0번 인덱스는 빈 값으로 정의
    static int[][] graph = {{}, {2,3,8}, {1,6,8}, {1,5}, {5,7}, {3,4,7}, {2}, {4,5}, {1,2}};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {

        int start = 1;

        dfs(start);
    }

    static void dfs(int nodeIndex) {

        // 방문 처리
        visited[nodeIndex] = true;

        System.out.print(nodeIndex + " ");

        // 방문한 노드에 인접한 노드 찾기
        for (int node : graph[nodeIndex]) {
            // 인접한 노드가 방문한 적이 없다면 DFS 수행
            if(!visited[node]){
                dfs(node);
            }
        }


    }

}

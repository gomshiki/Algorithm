import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M;
    static boolean[] visited;
    static List<List<Integer>> country;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            
            country = new ArrayList<>();

            for (int j = 0; j < N + 1; j++) {
                country.add(new ArrayList<>());
            }

            for (int j = 0; j < M; j++) {
                String[] split = br.readLine().split(" ");
                int a = Integer.parseInt(split[0]);
                int b = Integer.parseInt(split[1]);

                // 간선연결
                country.get(a).add(b);
                country.get(b).add(a);
            }

            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= N; j++) {
                visited = new boolean[N + 1];
                int count = bfs(j);

                min = Math.min(count, min);

            }
            sb.append(min).append("\n");
            
        }
        System.out.println(sb.toString());

    }

    static int bfs(int startNode) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        visited[startNode] = true;
        int cnt = 0;

        while (!queue.isEmpty()) {
            int nowNode = queue.poll();
            for (int i = 0; i < country.get(nowNode).size(); i++) { // 현재 노드와 연결된 모든 노드를 검사
                int nextNode = country.get(nowNode).get(i);
                if (!visited[nextNode]) {
                    queue.add(nextNode);
                    visited[nextNode] = true;
                    cnt++;
                }
            }
        }

        return cnt;
    }

}

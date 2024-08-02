import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 처음 A, B, C, D 중 한 개를 선택할 확률은 0.25
 * 입력 데이터로 2가 주어질 경우 움직임은 2번 수행
 * <p>
 * 테스트 케이스
 * 도착지가 C인 경우
 * A -> B -> C  : 0.25 * 1.0 * 0.3 = 0.075
 * <p>
 * 도착지가 B인 경우
 * C -> A -> B  : 0.25 * 0.6 * 1.0 = 0.15
 * <p>
 * 도착지가 A인 경우
 * B -> C -> A  : 0.25 * 0.3 * 0.6 = 0.045
 * <p>
 * 도착지가 D 인 경우
 * A -> B -> D 인 경우 : 0.25 * 1.0 * 0.7 = 0.175
 * B -> C -> D 인 경우 : 0.25 * 0.3 * 0.4 = 0.03
 * B -> D -> D 인 경우 : 0.25 * 0.7 * 1.0 = 0.175
 * C -> D -> D 인 경우 : 0.25 * 0.4 * 1.0 = 0.1
 * D -> D -> D 인 경우 : 0.25 * 1.0 * 1.0 = 0.1
 * 합계 : 0.175 + 0.03 + 0.175 + 0.1 + 0.1 = 0.73
 */
public class Main {
    static Map<Character, List<Edge>> adjList = new HashMap();
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static Map<Character, Double> result = new HashMap<>();
    static char destNode;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int moveCnt = Integer.parseInt(br.readLine());  // 움직일수 있는 횟수
        int vertex = Integer.parseInt(br.readLine()); // 간선의 개수

        // 인접 리스트 사용
        for (int i = 0; i < vertex; i++) { // 간선만큼 수행
            st = new StringTokenizer(br.readLine(), " ");

            char from = st.nextToken().charAt(0);
            char to = st.nextToken().charAt(0);
            double weight = Double.parseDouble(st.nextToken());

            adjList.putIfAbsent(from, new ArrayList<>());
            adjList.get(from).add(new Edge(to, weight));

        }

        // dfs로 풀기
        for (Character startNode : adjList.keySet()) {
            dfs(startNode, moveCnt,0.25);
        }

        // 출력
        for (Double value : result.values()) {
            double result = value * 100.0;
            sb.append(result).append("\n");
        }
        System.out.println(sb.toString());

    }

    static void dfs(char startNode, int moveCnt, double probability) {
        if (moveCnt == 0) {
            result.put(startNode, result.getOrDefault(startNode, 0.0) + probability);
            return;
        }

        List<Edge> edges = adjList.get(startNode);
        if (edges != null) {
            for (Edge edge : edges) {
                dfs(edge.node, moveCnt - 1, probability * edge.weight);
            }
        }
    }

    static class Edge {
        char node;
        double weight;

        public Edge(char node, double weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "node=" + node +
                    ", weight=" + weight +
                    '}';
        }
    }
}

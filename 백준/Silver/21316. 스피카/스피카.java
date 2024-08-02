import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<List<Integer>> adjList = new ArrayList<>();
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        for (int i = 0; i <= 12; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 1; i <= 12; i++) {
            // 노드 입력받기
            st = new StringTokenizer(br.readLine(), " ");
            int startNode = Integer.parseInt(st.nextToken());
            int endNode = Integer.parseInt(st.nextToken());

            // 간선 입력
            adjList.get(startNode).add(endNode);
            adjList.get(endNode).add(startNode);
        }

        //print(adjList);

        for (int i = 1; i < adjList.size(); i++) {

            List<Integer> linkedNodes = adjList.get(i);
            check = new boolean[4];

            for (Integer nextNode : linkedNodes) {
                int size = adjList.get(nextNode).size();
                check[size] = true;
            }

            int cnt = 0;
            for (boolean value : check) {
                if (value) {
                    cnt++;
                }
            }
            if (cnt == 3) {
                System.out.println(i);
                break;
            }
        }

    }

}

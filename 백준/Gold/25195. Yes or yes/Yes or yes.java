import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 1.입력
 * 1.1 N : 정점의 개수, M : 간선의 개수
 * 1.2 M개의 간선정보를 입력받는다. 연결리스트 사용
 */
public class Main {
    static List<Integer>[] map; // List<Integer> 타입의 배열
    static List<Integer> check;
    static List<Integer> fans;
    static int n;
    static boolean answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); // 노드 갯수
        int m = sc.nextInt(); // 간선 갯수
        sc.nextLine();

        map = new ArrayList[n];
        check = new ArrayList<>();
        fans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            map[i] = new ArrayList<>(); // 연결 리스트 생성
        }

        for (int i = 0; i < m; i++) {
            int startNode = sc.nextInt() - 1;
            int endNode = sc.nextInt() - 1;
            map[startNode].add(endNode);
        }

        int fanNodes = sc.nextInt();
        for (int i = 0; i < fanNodes; i++) {
            fans.add(sc.nextInt() - 1);
        }

        dfs(0);

        System.out.println(answer ? "yes" : "Yes");

    }

    static void dfs(int node) {
        if (fans.contains(node)) {
            return;
        }
        if (map[node].isEmpty()) {
            answer = true;
            return;
        }

        for (int i = 0; i < map[node].size(); i++) {
            Integer nextNode = map[node].get(i);
            if (!map[nextNode].isEmpty()) {
                dfs(nextNode);
            }
            if (map[nextNode].isEmpty() && !fans.contains(nextNode)) {
                answer = true;
            }
        }
    }
}

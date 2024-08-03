import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 1. 입력
 * 1.1 정수 2 <= n <=26
 * 1.2.0 a is b => a 와 b 는 서로 다른 알파벳 => 모든 a는 b이다 를 의미
 * 1.2.1 하지만 '모든 b 가 a 이다'는 의마는 아님
 * 1.2.2 a is b 이면 c 일수 없음 => a -> b && a -> c 일수 없단얘기 : 각 노드는 한개의 간선만 가진다.
 * 1.2.3 a 와 b가 동시에 c 일수는 있음 => a -> c && b -> C : 각 노드는 동일한 한개의 노드를 바라볼수 있다는 얘기인듯?
 * 2.1 정수 M <=10 개의 결론이 주어짐
 * <p>
 * 2. 풀이
 * 2.1 예시분석
 * a => b && b => C && c => d 인 경우 : a => c , a=>d, b =>d
 * 2.2 각 알파벳의 연결리스트로 표현해야함
 * 2.2.1 연결리스트는 Map<Character, Character>로 하면 될듯 한개의 노드는 한개의 간선만 가지니까..
 * 2.2.2 m 에서 주어진 결론을 풀어얘기해보면 a -> b -> c-> d 까지 다달을경우 True인거고 d -> a이면 간선 연결이 없으니 False 인듯
 * 2.2.3 2.2.2 모든 노드와 간선을 뒤져봐야하니까 완전탐색인데 다음 노드를 타고타고 들어가는 형태라서 dfs가 맞을듯?
 * 2.3 Map<a, b> 형태로 n 개의 노드와 간선정보를 입력받는다.
 * 2.4 m 개의 결론 정보를 받을떄마다 dfs를 수행해서 결과값에 도달하면 true를 아니면 false를 반환한다.
 * 2.4.1 이때 결과는 StringBuilder에 담는다.
 * 2.5 static boolean dfs(character startNode) 메서드를 정의
 * 2.5.1 if(map.get(startNode)) 가 true 이면 return true, 아니면 false return
 * <p>
 * 3. 출력
 * 3.1 m 개의 줄에 결론이 참인지 거짓인지 출력
 * 3.1.1 참이면 'T'
 * 3.1.2 거짓이면 'F'
 */
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static Map<Character, Character> adjList = new HashMap<>();
    static int n, m;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            char from = st.nextToken().charAt(0);
            st.nextToken(); // is 는 필요없음
            char to = st.nextToken().charAt(0);

            adjList.put(from, to); // 단방향이라 한번만 추가해주면됨
        }

        m = Integer.parseInt(br.readLine());
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            char startNode = st.nextToken().charAt(0);
            st.nextToken(); // is 는 필요없음
            char endNode = st.nextToken().charAt(0);
            sb.append(dfs(startNode, endNode) ? 'T' : 'F').append("\n");
        }

        System.out.println(sb.toString());
    }

    static boolean dfs(char node, char endNode) {
        if (node == endNode) {
            return true;
        }

        if (adjList.containsKey(node)) {
            char nextNode = adjList.get(node);
            return dfs(nextNode, endNode);
        }
        return false;
    }
}

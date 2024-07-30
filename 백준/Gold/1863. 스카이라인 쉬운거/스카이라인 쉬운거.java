import java.util.*;
import java.io.*;

/**
 * 1. 규칙 : 높이가 높아지면 스택에 push
 * 2. 높이가 낮아지면 높은 건물의 넓이가 끝나는 시점으로 스택에서 뽑고 answer++
 *   - 새로운 높이라면 push
 *   - 기존 높이와 같다면 continue
 * 4. stack 이 비어있다면 무조건 push
 * 5. 모든 탐색이 끝나면 stack을 비우고 answer++
 */
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int answer = 0;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            /**
             * 스택이 안비어있고, 마지막 값이 y 보다 클때
             * 건물 (answer)을 하나 추가하고 stack에서 pop 한다.
             * 높이가 낮아졌다는 것 => 건물이 하나 더있다는 의미
             */
            while (!stack.isEmpty() && stack.peek() > y) {
                answer++;
                stack.pop();
            }

            // 높이가 같다면? => 같은 빌딩이라는 의미 : Stack에 넣을 필요가 없음
            if (!stack.isEmpty() && stack.peek() == y) {
                continue;
            }

            // 높이가 높아졌다면 ? => push해서 최고층 높이의 건물을 갱신한다.
            stack.push(y);
        }

        // 스택이 안비었다면?
        while (!stack.isEmpty()) {

            // 남은 건물이 있다는 뜻으로 건물(answer)에 1더해주고 pop 수행
            if (stack.peek() > 0) {
                answer++;
            }
            stack.pop();
        }

        System.out.println(answer);
    }
}

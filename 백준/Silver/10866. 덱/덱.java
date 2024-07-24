import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            switch (order) {
                case "push_front":
                    deque.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    deque.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    Integer pollFirst = deque.pollFirst();
                    sb.append(pollFirst == null ? -1 : pollFirst).append("\n");
                    break;
                case "pop_back":
                    Integer polledLast = deque.pollLast();
                    sb.append(polledLast == null ? -1 : polledLast).append("\n");
                    break;
                case "size":
                    sb.append(deque.size()).append("\n");
                    break;
                case "empty":
                    sb.append(deque.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "front":
                    Integer peekFirst = deque.peekFirst();
                    sb.append(peekFirst == null ? -1 : peekFirst).append("\n");
                    break;
                case "back":
                    Integer peekLast = deque.peekLast();
                    sb.append(peekLast == null ? -1 : peekLast).append("\n");
                    break;
                default:
                    break;
            }
        }
        System.out.println(sb);
    }
}

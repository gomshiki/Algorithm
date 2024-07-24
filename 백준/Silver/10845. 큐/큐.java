import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        Deque<String> deque = new LinkedList<>(); // Tail을 뽑기 위해 Deque 사용
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            switch (order) {
                case "push" :
                    deque.add(st.nextToken());
                    break;
                case "pop":
                    sb.append(deque.isEmpty() ? -1 : deque.poll()).append("\n");
                    break;
                case "size":
                    sb.append(deque.size()).append("\n");
                    break;
                case "empty":
                    sb.append(deque.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "front":
                    sb.append(deque.isEmpty() ? -1 : deque.peek()).append("\n");
                    break;
                case "back":
                    sb.append(deque.isEmpty() ? -1 : deque.peekLast()).append("\n"); 
                    break;
                default:
                    break;
            }
        }
        System.out.println(sb);
    }
}

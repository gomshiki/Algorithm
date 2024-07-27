import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main { // 최소 힙 : 부모노드가 자식노드보다 항상 작아야함. => 오름차순
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            int parseInt = Integer.parseInt(br.readLine());

            if (parseInt > 0) {
                pq.offer(parseInt);
            }
            if (parseInt == 0) {
                if (pq.isEmpty()) {
                    sb.append(0).append("\n");
                }else{
                    sb.append(pq.poll()).append("\n");
                }
            }
        }

        System.out.println(sb.toString());
    }
}

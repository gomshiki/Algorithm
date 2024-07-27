import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine()); // 방문횟수 n

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());

            if (a == 0) {
                if (pq.isEmpty()) {
                    sb.append(-1).append("\n");
                }else{
                    sb.append(pq.poll()).append("\n");
                }
            }else{
                for (int j = 0; j < a; j++) {
                    pq.add(Integer.parseInt(st.nextToken()));
                }
            }
        }

        System.out.println(sb.toString());
    }
}

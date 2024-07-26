
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
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 거인 수
        long nowHeight = Long.parseLong(st.nextToken()); // 센티의 키
        int cnt = Integer.parseInt(st.nextToken()); // 사용가능한 뿅망치 횟수

        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < N; i++) {
            String height = br.readLine();
            pq.add(Long.parseLong(height));
        }

        // 뿅망치 사용
        int minCnt = 0;
        for (int i = 0; i < cnt; i++) {

            if (pq.peek() == 1 || pq.peek() < nowHeight) {
                break;
            }
            minCnt++;
            pq.add(pq.poll() / 2l);
        }

        if (pq.peek() < nowHeight) {
            sb.append("YES").append("\n").append(minCnt);
        } else {
            sb.append("NO").append("\n").append(pq.peek());
        }

        System.out.println(sb);
    }
}

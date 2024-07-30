import java.util.*;
import java.io.*;

/**
 * 1. 입력
 * 1-1. T : 테스트 데이터의 개수
 * 1-2. K : 소설 장의 수 (3 <= K <= 1_000_000)
 * 1-3. fileSize : 1~ K 장까지의 파일 크기가 K 개 주어짐 (파일 크기 < 10_000)
 * <p>
 * 2. 로직
 * <p>
 * <p>
 * 3. 출력
 * 3-1. 각 테스트 별 최소비용을 출력
 */
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int K = Integer.parseInt(br.readLine());
            PriorityQueue<Long> pq = new PriorityQueue<>();
            st = new StringTokenizer(br.readLine());
            // 장수 입력
            for (int j = 0; j < K; j++) {
                pq.add(Long.parseLong(st.nextToken()));
            }

            Long sum = 0l;
            while (pq.size() > 1) {
                long a = pq.poll();
                long b = pq.poll();

                sum += a + b;
                pq.add(a + b);
            }

            sb.append(sum).append("\n");

        }

        System.out.println(sb.toString());

    }
}

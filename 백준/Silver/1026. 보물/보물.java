import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 1. 입력
 *  1-1. 각 A,B 배열에 숫자를 입력받는다.
 * 
 * 2. 문제풀이
 *  2-1. A,B열을 각각 우선순위큐에 담는데 최소힙과 최대힙으로 나눠 담는다.
 *  2-2. 합계 변수 sum을 초기화 후 최소힙과 최대힙 우선순위큐를 poll 해서 곱한 값을 sum에 계속더한다.
 * 
 * 3. 출력
 *  3-1. sum을 StringBuilder에 담고, 출력한다.
 */
public class Main {
    static int[] A, B;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        A = new int[n];
        B = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i : A) {
            minHeap.add(i);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : B) {
            maxHeap.add(i);
        }

        int sum = 0;
        while (!minHeap.isEmpty() && !maxHeap.isEmpty()) {
            sum += minHeap.poll() * maxHeap.poll();
        }
        sb.append(sum);

        System.out.println(sb.toString());
    }

}

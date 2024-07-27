import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        // 작은값부터 나와야함
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // 오름차순

        // 두힙의 중간값을 구하는게 목적!

        // 큰값부터 나와야함.
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // 내림차순

        boolean isOdd = true; // 홀수 인지 확인

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if (isOdd) { // 홀수라면 왼쪽 maxHeap에 넣어줘야함
                maxHeap.offer(num);
            } else {
                minHeap.offer(num);
            }

            // 들어간 maxHead의 값이 minHead 보다 크다면 자리를 바꿔줘야함!
            if (!minHeap.isEmpty()) { // 홀수번째는 MaxHeap에만 값이 들어가있는데 이경우 MinHeap이 비여있을 수 있음
                if (maxHeap.peek() > minHeap.peek()) {
                    maxHeap.offer(minHeap.poll());
                    minHeap.offer(maxHeap.poll());
                }
            }

            // 중간 값읜 왼쪽 maxHeap에 존재
            sb.append(maxHeap.peek()).append("\n");

            isOdd = !isOdd;

        }
        System.out.println(sb);
    }
}

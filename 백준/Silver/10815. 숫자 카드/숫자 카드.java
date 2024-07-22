import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 상근이가 가지고 있는 카드의 개수 N
        int N = Integer.parseInt(br.readLine());

        // 상근이가 가지고 있는 카드
        int[] cards = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        // 가지고 있는 숫자카드인지 판별할 카드
        int M = Integer.parseInt(br.readLine());
        int[] targetCards = new int[M];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            targetCards[i] = Integer.parseInt(st2.nextToken());
        }
        /**
         * 상근이 카드를 오름차순 정렬
         * Arrays.sort() :
         * 	1.	기본 타입 배열 (예: int[], double[] 등): Dual-Pivot Quick Sort 알고리즘을 사용합니다.
         * 	    이 알고리즘은 일반적인 퀵 정렬 알고리즘의 변형으로, 두 개의 피벗을 사용하여 성능을 향상시킵니다.
         * 	    평균 시간 복잡도는 O(n log n)입니다.
         *
         * 	2.	객체 배열 (예: String[], Integer[] 등): Timsort 알고리즘을 사용합니다.
         * 	    Timsort는 합병 정렬과 삽입 정렬을 결합한 하이브리드 알고리즘으로, 최선의 경우 시간 복잡도는 O(n)이며,
         * 	    평균 및 최악의 경우 시간 복잡도는 O(n log n)입니다.
         */

        Arrays.sort(cards);

        for (int i = 0; i < M; i++) {
            // binarySearch : 이진 탐색 반환 값으로 원하는 값이 있으면 해당 인덱스 반환, 없으면 음수 반환
            int result = Arrays.binarySearch(cards, targetCards[i]);
            sb.append(result >= 0 ? 1 : 0).append(" ");
        }
        System.out.println(sb);


    }

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * HashMap과 TreeMap의 getOrDefault로 풀었을때 테스트케이스는 정답이나 시간초과발생
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 상근이 카드 개수
        int N = Integer.parseInt(br.readLine());
        int[] cards = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }


        // 오름차순 정렬
        Arrays.sort(cards);

        // 타겟 카드 개수
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int[] targetNums = new int[M];

        for (int i = 0; i < M; i++) {
            // 타겟 카드 번호
            targetNums[i] = Integer.parseInt(st2.nextToken());
        }


        for (int i = 0; i < M; i++) {
            int lowerIndex = lowerBound(cards, targetNums[i]);
            int upperIndex = upperBound(cards, targetNums[i]);
            int result = upperIndex - lowerIndex;
            sb.append(result).append(" ");
        }

        System.out.println(sb);

    }
    // 0   1  2 3  4  5 6 7  8  9
    //-10 -10 2 3  3  6 7 10 10 10  : key 10
    static int lowerBound(int[] arr, int key) { // key = 10
        int low = 0;
        int high = arr.length; // 10

      while(low < high){ // 0 < 10 T, 7 < 10 T, 7 < 8 T, 7 < 7 f
          int mid = (high + low) / 2; // 5, 8, 7
          if (arr[mid] >= key) {// 6 > 10 F, 10 = 10, 10 = 10
              high = mid; // 8, 7
          }else{
              low = mid + 1; // 7
          }
      }

      return low; // low = 0, 7
    }

    //-10 -10 2 3  3  6 7 10 10 10  : key 10
    static int upperBound(int[] arr, int key) { // 10
        int low = 0;
        int high = arr.length;// 10

        while (low < high) { // 0 < 10: T, 7 < 10 : T, 8 < 10 T, 9 < 10 T, 10 < 10 F
            int mid = (low + high) / 2; // 5, 8, 9, 9
            if (arr[mid] > key) { // 6 > 10 F, 10 > 10, 10 > 10, 10> 10,
                high = mid;
            }else{
                low = mid + 1; // low = 7, 8, 9, 10
            }
        }

        return low; // 10
    }

}

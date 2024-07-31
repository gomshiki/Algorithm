import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Map<Integer, Integer> rankMap = new HashMap<>();
    static StringBuilder sb = new StringBuilder();
    static int[] array, sortedArray;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        array = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        // 정렬된 배열 초기화
        sortedArray = array.clone();

        // 배열 정렬
        Arrays.sort(sortedArray);


        //배열의 압축값을 map에 저장
        int rank = 0;
        for (int value : sortedArray) {
            if (!rankMap.containsKey(value)) {
                rankMap.put(value, rank);
                rank++;
            }
        }

        // 원본 배열을 순선대로 출력
        for (int value : array) {
            sb.append(rankMap.get(value)).append(' ');
        }

        System.out.println(sb.toString());

    }
}

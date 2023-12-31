package 단계별문제풀이.일차원배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class 공바꾸기 {

    /**
     * IntStream.rangeClosed(1, 10) : 1부터 9까지 값을 반환
     */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        int[] arry = IntStream.rangeClosed(1, N).toArray();

        int temp = 0;

        for (int i = 0; i < M; i++) {

            String[] s = br.readLine().split(" ");

            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);

            temp = arry[a-1];
            arry[a-1] = arry[b-1];
            arry[b-1] = temp;

        }
        Arrays.stream(arry).mapToObj(item -> item + " ").forEach(System.out::print);
    }

}

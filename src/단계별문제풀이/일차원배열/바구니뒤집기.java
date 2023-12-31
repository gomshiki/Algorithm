package 단계별문제풀이.일차원배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class 바구니뒤집기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] array = IntStream.rangeClosed(1, N).toArray();

        for (int i = 0; i < M; i++) {
            String[] s = br.readLine().split(" ");

            int left = Integer.parseInt(s[0]) -1; // 0 3 일 경우
            int right = Integer.parseInt(s[1])-1;

            while (left < right) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                left++;
                right--;
            }


        }

        Arrays.stream(array).mapToObj(item -> item + " ").forEach(System.out::print);

    }

}

package 단계별문제풀이.일차원배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class X보다작은수 {

    /**
     * 정수 N개로 이루어진 수열 A와 정수 X가 주어지고, A 에서 X 보다 작은 수를 모두 출력하는 프로그램을 작성하시오
     */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        int X = Integer.parseInt(s[1]);

        Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                .filter(item -> item < X).mapToObj(item -> item + " ").forEach(System.out::print);


    }
}

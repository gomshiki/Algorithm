package 단계별문제풀이.반복문;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 합 {

    // n이 주어졌을대 1 + 2 + 3 + ... + n 까지 합 반환
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int inputNum = Integer.parseInt(br.readLine());


        int sum = 0;

        for (int i = 1; i <= inputNum; i++) {
            sum += i;
        }

        System.out.println(sum);
    }
}

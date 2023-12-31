package 단계별문제풀이.반복문;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class A더하기B빼기7 {

    // 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int quantity = Integer.parseInt(br.readLine());

        String addString = "Case #";

        for (int i = 0; i < quantity; i++) {
            int sum = 0;
            String[] s = br.readLine().split(" ");
            int sum1 = Arrays.stream(s).mapToInt(Integer::parseInt).sum();
            sb.append(addString + (i+1) + ": " + sum1 + "\n");

        }

        System.out.println(sb.toString());


    }

}

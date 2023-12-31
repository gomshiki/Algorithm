package 단계별문제풀이.반복문;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class A더하기B빼기8 {

    // 각 테스트 케이스마다 "Case #x: A + B = C" 형식으로 출력한다. x는 테스트 케이스 번호이고 1부터 시작하며, C는 A+B이다.
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int count = Integer.parseInt(br.readLine());

        for (int i = 1; i < count + 1; i++) {

            sb.append("Case #"+ i + ": ");

            String[] s = br.readLine().split(" ");
            int[] intArray = Arrays.stream(s).mapToInt(Integer::parseInt).toArray();

            sb.append(intArray[0] +" + " +  intArray[1] + " = " + Arrays.stream(intArray).sum() + "\n");

        }

        System.out.println(sb.toString());

    }

}

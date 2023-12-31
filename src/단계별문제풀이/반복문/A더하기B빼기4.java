package 단계별문제풀이.반복문;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class A더하기B빼기4 {

    // EOF 처리 : End of File 약자로 데이터 소스로부터 더이상 읽어드릴 데이터가 없음을 나타내는 용어
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {

            String intputData = br.readLine();

            if (intputData == null || intputData.length() == 0) {
                break;
            }else{
                int sum = Arrays.stream(intputData.split(" ")).mapToInt(Integer::parseInt).sum();
                System.out.println(sum);
            }

        }


    }

}

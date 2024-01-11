package 단계별문제풀이.수학1;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

/**
 * 거스름돈의 액수가 주어지면 리암이 줘야할
 * 쿼터(Quarter, $0.25)의 개수,
 * 다임(Dime, $0.10)의 개수,
 * 니켈(Nickel, $0.05)의 개수,
 * 페니(Penny, $0.01)의 개수를 구하는 프로그램을 작성하시오.
 * 거스름돈은 항상 $5.00 이하이고, 손님이 받는 동전의 개수를 최소로 하려고 한다.
 *
 * 예를 들어, $1.24를 거슬러 주어야 한다면, 손님은 4쿼터, 2다임, 0니켈, 4페니를 받게 된다.
 *
 */
public class 세탁소사장동혁 {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 쿼터($0.25), 다임($0.10), 니켈($0.05), 페니($0.01)
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        for (int i = 0; i < T; i++) {

            // double 계산시 에러 발생 => 정수로 변환해서 처리 cent 기준!

            int changes = Integer.parseInt(br.readLine());// 124 cent = $1.24

            int resultQ = changes / 25 ;
            int remainQ = changes % 25 ;

            int resultD = remainQ / 10;
            int remainD = remainQ % 10;

            int resultN = remainD / 5;
            int remainN = remainD % 5;

            int resultP = remainN / 1;

            // 쿼터 $0.25 = 25 센트
            // 다임 $0.1 =  10 센트
            // 니켈 $0.05 = 5  센트
            // 페니 $0.01 = 1  센트

            sb.append(resultQ + " " + resultD + " " + resultN + " " + resultP).append("\n");


        }

        System.out.println(sb.toString());




    }

}

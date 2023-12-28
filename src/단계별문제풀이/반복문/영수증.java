package 단계별문제풀이.반복문;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 영수증 {

    // 영수증의 금액과 구매한 제품의 종류 수가 주어지고
    // 실제 구매한 제품의 가격과 수량을 계산하여 영수증 총 금액과 맞는지 비교
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int totalCost = Integer.parseInt(br.readLine());
        int totalQty = Integer.parseInt(br.readLine());

        int sum=0;

        for (int i = 0; i < totalQty; i++) {
            String[] split = br.readLine().split(" ");
            sum += Integer.parseInt(split[0]) * Integer.parseInt(split[1]);
        }

        System.out.println(totalCost == sum ? "Yes" : "No");

    }
}

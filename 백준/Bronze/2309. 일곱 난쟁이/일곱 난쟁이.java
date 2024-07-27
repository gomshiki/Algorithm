import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] dwarfs = new int[9]; // 아홉난쟁이의 키를 배열에 담는다.
        int sum = 0; // 아홉 난쟁이의 전체 키 합을 구한다.
        for (int i = 0; i < 9; i++) {
            int height = Integer.parseInt(br.readLine());
            dwarfs[i] = height;
            sum += height;
        }

        Arrays.sort(dwarfs); // 오름차순 정렬한다.

        int gap = sum - 100; // 아홉난쟁이의 전체 키에서 진짜 일곱난쟁이의 키 100 을 뺀다.

        // 가짜 난쟁이 두명 찾기
        int targetNum1 = -1;
        int targetNum2 = -1;

        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (dwarfs[i] + dwarfs[j] == gap) { // 두 난쟁이 키의 합이 gap이면 해당 키값을 초기화
                    targetNum1 = dwarfs[i];
                    targetNum2 = dwarfs[j];
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 9; i++) {
            int dwarf = dwarfs[i];
            if (dwarf != targetNum1 && dwarf != targetNum2) {
                sb.append(dwarf).append("\n");
            }
        }

        System.out.println(sb);



    }
}

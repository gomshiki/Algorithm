package 단계별문제풀이.일차원배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class 나머지 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int targetNum = 42;

        int[] arry = new int[10];

        for (int i = 0; i < 10; i++) {

            int a = Integer.parseInt(br.readLine());

            arry[i] = a % targetNum;

        }

        long count = Arrays.stream(arry).distinct().count();
        System.out.println(count);

        // 방법 2
        HashSet<Integer> hashSet = new HashSet<>();

    }

}

class solution2 {

    /**
     *  HashSet은 값을 저장할 때 중복제거해서 저장하는 자료구조!!
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int targetNum = 42;

        HashSet<Integer> hashSet = new HashSet<>();


        for (int i = 0; i < 10; i++) {

            int a = Integer.parseInt(br.readLine());


            hashSet.add(a % targetNum);

        }
        System.out.println(hashSet.size());

    }
}
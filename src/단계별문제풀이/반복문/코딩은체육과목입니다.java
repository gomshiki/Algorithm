package 단계별문제풀이.반복문;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 25314번
public class 코딩은체육과목입니다 {

    // 20 byte = long long long long int
    // 12 byte = long long long int
    // 8 byte = long long int = long long
    // 4 byte = long int
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int intputByte = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        int count = intputByte / 4; // 20 / 4 = 5;

        for (int i = 0; i < count ; i++) {

            if( intputByte == 4 ){
                sb.append("long int");
            }else{
                sb.append("long ");
            }
            intputByte -= 4 ;
        }

        System.out.println(sb.toString());

    }
}

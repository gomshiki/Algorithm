import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int cnt = 0;
        for (int i = 0; i < array.length; i++) {
            int currentSum = 0;
            for (int j = i; j < array.length; j++) {
                currentSum += array[j];
                if(currentSum == M){
                    cnt++;
                }
            }
        }

        System.out.println(cnt);



    }
}

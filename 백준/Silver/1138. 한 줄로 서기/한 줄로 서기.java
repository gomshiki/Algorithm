import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] answer = new int[N + 1];


        for (int number = 1; number <= N; number++) {
            int counts = Integer.parseInt(st.nextToken());

            for (int j = 1; j <= N; j++) {
                if (counts == 0) {
                    if(answer[j] == 0){
                        answer[j] = number;
                        break;
                    }else{
                        continue;
                    }
                }
                if (answer[j] == 0) {
                    counts--;
                }

            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(answer[i] + " ");
        }

    }
}

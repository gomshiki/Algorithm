import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[2];

        for (int i = 0; i < 2; i++) {
            StringBuilder sb = new StringBuilder(st.nextToken());
            arr[i] = Integer.parseInt(sb.reverse().toString());
        }

        int max = Arrays.stream(arr).max().getAsInt();

        System.out.println(max);
    }
}

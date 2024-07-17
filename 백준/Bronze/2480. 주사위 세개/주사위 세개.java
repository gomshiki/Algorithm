import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[6];

        for (int i = 0; i < 3; i++) {
            int targetIndex = Integer.parseInt(st.nextToken());
            arr[targetIndex - 1]++;
        }

        int count = 0;
        int max = 0;
        for (int i = 0; i < 6; i++) {
            if (arr[i] == 3) {
                sb.append(tripleDice(i + 1));
                break;
            }
            if (arr[i] == 2) {
                sb.append(doubleDice(i + 1));
                break;
            }
            if (arr[i] == 1) {
                count++;
                max = i + 1;
            }
        }

        if (count == 3) {
            sb.append(noneDice(max));
        }

        System.out.println(sb);


    }

    static int tripleDice(int index) {
        return 10_000 + index * 1_000;
    }

    static int doubleDice(int index) {
        return 1_000 + index * 100;
    }

    static int noneDice(int index) {
        return index * 100;
    }
}

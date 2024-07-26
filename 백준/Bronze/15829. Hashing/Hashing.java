import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());

        String string = br.readLine();


        int r = 31;
        int sum = 0;

        for (int i = 0; i < L; i++) {
            int targetAlphabet = string.charAt(i) - 'a' + 1;
            sum += targetAlphabet * Math.pow(r, i);
        }

        System.out.println(sum);
    }

}

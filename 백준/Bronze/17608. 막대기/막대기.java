import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            stack.push(Integer.parseInt(br.readLine()));
        }

        Integer max = stack.pop();

        int cnt = 1;

        while (!stack.isEmpty()) {
            Integer nowPilar = stack.pop();

            if (max < nowPilar) {
                max = nowPilar;
                cnt++;
            }

        }

        System.out.println(cnt);


    }
}

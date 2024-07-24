import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            Stack<String> stack = new Stack<>();
            String[] words = br.readLine().split(" ");
            for (String word : words) {
                stack.push(word);
            }
            
            sb.append("Case #").append(i+1).append(": ");
            for (int j = 0; j < words.length; j++) {
                sb.append(stack.pop()).append(" ");
            }
            sb.append("\n");

        }
        System.out.println(sb);

    }
}

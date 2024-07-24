import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        count = 0;
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            goodWordCheck(s);
        }

        System.out.println(count);


      /* 시간초과
      for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (word.length() % 2 != 0) {
                continue;
            }
            String pattern1 = "AA";
            String pattern2 = "BB";

            while (true) {
                if (!word.contains(pattern1) && !word.contains(pattern2)) {
                    break;
                }
                if (word.contains(pattern1)) {
                    word = word.replaceAll(pattern1, "");
                }
                if (word.contains(pattern2)) {
                    word = word.replace(pattern2, "");
                }
            }
            if (word.isEmpty()) {
                cnt++;
            }
        }*/

    }

    static void goodWordCheck(String word) {
        if(word.length() % 2 != 0 ) return; // 홀수면 무조건 아님
        Stack<Character> stack = new Stack<>();
        stack.push(word.charAt(0)); // 첫 character 는 stack 에 저장

        for (int i = 1; i < word.length(); i++) {
            if (stack.size() > 0 && stack.peek() == word.charAt(i)) {
                stack.pop();
            }else{
                stack.push(word.charAt(i));
            }
            
        }

        if(stack.isEmpty()) count++;
    }
}

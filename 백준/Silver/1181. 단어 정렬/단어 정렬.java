import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 1. 입력
 *  1-1. 입력받을 단어의 개수 n (1 <= n <= 20_000)
 *  1-2. 소문자 단어 n개 받기(단어 길이는 50 이하)
 *
 *
 * 2. 문제풀이
 *  2-0. 중복제거를 위해 Set에 담는다.
 *  2-1. 단어 정보를 가진 클래스 선언 및 comparable 상속 후 compareTo @Override
 *  2-2. compareTo 조건에 길이가 짧은 것, 다음 사전 순 정렬 조건 추가
 *  2-3. Set에 담긴 단어를 for문을 돌며 우선순위큐에 담는다.
 *
 * 3. 출력
 *  3-1. 우선순위큐가 빌때까지 Poll()로 빼낸 후 StringBuilder에 담는다.
 *  3-2. StringBuilder를 출력한다.
 */
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static PriorityQueue<WordInfo> pq = new PriorityQueue<>();
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        // 1. 중복 제거를 위해 set에 담는다.
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            set.add(word);
        }

        // 2. set에 담긴 단어를 WordInfo 클래스의 필드로 사용하여 우선순위 큐에 담는다.
        for (String word : set) {
            pq.add(new WordInfo(word.length(), word));
        }


        // 3. 우선순위 큐가 빌때까지 한개씩 빼내어 StringBuilder에 담는다.
        while (!pq.isEmpty()) {
            sb.append(pq.poll().word).append("\n");
        }

        System.out.println(sb.toString());
    }

    static class WordInfo implements Comparable<WordInfo>{
        int wordLength;
        String word;

        public WordInfo(int wordLength, String word){
            this.wordLength = wordLength;
            this.word = word;
        }

        @Override
        public int compareTo(WordInfo w){
            if (this.wordLength == w.wordLength) {
                return this.word.compareTo(w.word);
            }else{
                return this.wordLength - w.wordLength;
            }

        }
    }
}

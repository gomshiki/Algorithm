class Solution {
    static char[] friends = new char[]{'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    static char[] arr = new char[friends.length];
    static boolean[] visited = new boolean[friends.length];
    static String[] data;
    static int answer = 0;

    public int solution(int n, String[] data) {
        Solution.data = data;
        Solution.answer = 0;
        perm(0);
        return answer;
    }

    static void perm(int index) {
        if (index == friends.length) {
            if (checkConditions()) {
                answer++;
            }
            return;
        }

        for (int i = 0; i < friends.length; i++) {
            if (!visited[i]) {
                arr[index] = friends[i];
                visited[i] = true;
                if (isValidPartial(index)) {
                    perm(index + 1);
                }
                visited[i] = false;
            }
        }
    }

    static boolean checkConditions() {
        for (String condition : data) {
            char friend1 = condition.charAt(0);
            char friend2 = condition.charAt(2);
            char symbol = condition.charAt(3);
            int distance = condition.charAt(4) - '0' + 1;

            int fr1Index = -1;
            int fr2Index = -1;

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == friend1) fr1Index = i;
                if (arr[i] == friend2) fr2Index = i;
            }

            if (symbol == '=' && Math.abs(fr1Index - fr2Index) != distance) return false;
            if (symbol == '>' && Math.abs(fr1Index - fr2Index) <= distance) return false;
            if (symbol == '<' && Math.abs(fr1Index - fr2Index) >= distance) return false;
        }
        return true;
    }

    static boolean isValidPartial(int index) {
        for (String condition : data) {
            char friend1 = condition.charAt(0);
            char friend2 = condition.charAt(2);
            char symbol = condition.charAt(3);
            int distance = condition.charAt(4) - '0' + 1;

            int fr1Index = -1;
            int fr2Index = -1;

            for (int i = 0; i <= index; i++) {
                if (arr[i] == friend1) fr1Index = i;
                if (arr[i] == friend2) fr2Index = i;
            }

            if (fr1Index != -1 && fr2Index != -1) {
                if (symbol == '=' && Math.abs(fr1Index - fr2Index) != distance) return false;
                if (symbol == '>' && Math.abs(fr1Index - fr2Index) <= distance) return false;
                if (symbol == '<' && Math.abs(fr1Index - fr2Index) >= distance) return false;
            }
        }
        return true;
    }
}
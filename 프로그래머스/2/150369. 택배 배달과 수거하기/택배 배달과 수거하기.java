import java.util.Stack;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        return resolve(cap, n, deliveries, pickups);
    }
    
    static long resolve(int cap, int n, int[] del, int[] pick) {
        long result = 0;
        Stack<Integer> pickStack = new Stack<>();
        Stack<Integer> delStack = new Stack<>();
        
        // 각 집의 수거와 배달 스택 초기화
        for (int i = 0; i < n; i++) {
            pickStack.push(pick[i]);
            delStack.push(del[i]);
        }
        
        while (!delStack.isEmpty() || !pickStack.isEmpty()) {
            int currentCap = cap;
            int distance = 0;
            
            // 배달 작업
            while (!delStack.isEmpty() && (delStack.peek() == 0 || currentCap == 0)) {
                delStack.pop();
            }
            if (!delStack.isEmpty()) {
                distance = Math.max(distance, delStack.size());
            }

            while (!delStack.isEmpty() && currentCap > 0) {
                int deliveries = delStack.pop();
                if (deliveries > currentCap) {
                    delStack.push(deliveries - currentCap);
                    currentCap = 0;
                } else {
                    currentCap -= deliveries;
                }
            }
            
            currentCap = cap;

            // 수거 작업
            while (!pickStack.isEmpty() && (pickStack.peek() == 0 || currentCap == 0)) {
                pickStack.pop();
            }
            if (!pickStack.isEmpty()) {
                distance = Math.max(distance, pickStack.size());
            }

            while (!pickStack.isEmpty() && currentCap > 0) {
                int pickups = pickStack.pop();
                if (pickups > currentCap) {
                    pickStack.push(pickups - currentCap);
                    currentCap = 0;
                } else {
                    currentCap -= pickups;
                }
            }
            
            result += distance * 2;
        }
        
        return result;
    }
}
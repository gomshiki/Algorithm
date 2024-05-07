class Solution {
     public int solution(long a, int b) {
        
         // 진수 변환
        String changeNum = Long.toString(a, b);
        
        // split
        String[] split = changeNum.split("0");

        int sum = 0;

        for (String s : split) {
            // 1인 경우와 null인 경우 제외
            if(!s.isEmpty() && !s.equals("1")){
                
                // 소수 판별
                if(isPrime(s)){
                    sum++;                    
                }
            }
                
            
        }

        return sum;
    }
    
    public boolean isPrime(String inputNum){
        long num = Long.parseLong(inputNum);
        
        
        for(long i = 2l; i <= Math.sqrt(num) ; i++){
            if(num % i == 0l) return false;
        }
        return true;
    }
}
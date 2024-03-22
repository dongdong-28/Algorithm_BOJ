class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        
        if(n == 1) answer = 1;
        else if(n ==2) answer = 2;
        else {
        for(int i =3;i<=n;i++) dp[i] = (dp[i-1] + dp[i-2]) % 1000000007;
        answer = dp[n];            
        }
    
        
        
        return answer;
    }
}
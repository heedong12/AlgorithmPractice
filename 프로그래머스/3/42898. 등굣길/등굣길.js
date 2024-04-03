function solution(m, n, puddles) {
    var answer = 0;
    const NUM = 1000000007;
    let dp = Array.from(Array(n), () => Array(m).fill(0));
    
    dp[0][0] = 1;
    
    for (let p of puddles){
        let x = p[1]-1;
        let y = p[0]-1;
        
        dp[x][y] = -1;
    }
    
    for (let i = 0; i < n; i++) { 
        for (let j = 0; j < m; j++) { 
            if (dp[i][j] === -1) {
                dp[i][j] = 0;
                continue;
            }
            if (i > 0)
                dp[i][j] += dp[i - 1][j] % NUM ;
            if (j > 0)
                dp[i][j] += dp[i][j - 1] % NUM ;
            dp[i][j] %= NUM;
        }
    }      
    
    answer = dp[n - 1][m - 1] 
    return answer;
}

function solution(numbers, target) {
    var answer = 0;
    
    const dfs = (node, sum) => {
        if(node === numbers.length){
            if(sum === target) answer++
            return
        }
        
        dfs(node+1, sum+numbers[node])
        dfs(node+1, sum-numbers[node])
    }
    
    dfs(0,0)
    return answer;
}
function solution(n, works) {
    var answer = 0;
    works.sort((a,b) => b-a);
    
    while(n) {
        let max = works[0]; // 가장 큰 값
        for(let i=0;i<works.length;i++){
             if (works[i] >= max) {
                works[i] -= 1;
                n -= 1;
             }
            if(!n) break;
        }
    }
    
    works.map((item)=>{
        if(item < 0) return;
        answer += Math.pow(Number(item), 2);
    })
    
    return answer;
}
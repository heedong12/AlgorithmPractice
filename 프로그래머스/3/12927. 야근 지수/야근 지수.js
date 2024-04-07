function solution(n, works) {
    var answer = 0;
    works.sort(function(a,b) {
        return b-a;
    });
    
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
        if(item < 0) item = 0;
        answer += Math.pow(Number(item), 2);
    })
    
    return answer;
}
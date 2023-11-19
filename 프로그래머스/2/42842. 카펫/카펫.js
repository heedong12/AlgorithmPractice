function solution(brown, yellow) {
    var answer = [];
    var temp=[1];
    
    for(let i=2;i<=yellow/2;i++){
        if(yellow%i==0){
            temp.push(i);
        }
    }
    
    for(let t of temp){
        if((t+1)*2+((yellow/t)+1)*2 == brown){
            answer.push(t+2);
            answer.push(yellow/t+2);
            break;
        }
    }
    
    
    answer.sort(function(a,b) {return b-a;});
    
    return answer;
}
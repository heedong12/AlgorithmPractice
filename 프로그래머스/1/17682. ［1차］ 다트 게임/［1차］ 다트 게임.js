function solution(dartResult) {
    var answer = 0;
    let score = [];
    let index = 0;
    let temp ='';

    for(let i=0;i<dartResult.length;i++){
        if(!isNaN(dartResult[i])){  //숫자
            score[index++]=temp;
            temp='';
            temp += dartResult[i];
            if(!isNaN(dartResult[i+1])) { //10인 경우
                temp += dartResult[i+1];
                i++;
            }
            continue;
        }  
        
        if(dartResult[i]=='D' || dartResult[i]=='T'){
            if(dartResult[i]=='D') temp=Math.pow(temp,2);
            if(dartResult[i]=='T') temp=Math.pow(temp,3);
            continue;
        }
        
        if(dartResult[i]=='*' || dartResult[i]=='#' ) {
            if(dartResult[i]=='*') {
                temp*=2;
                let previous = Number(score[index-1])*2;
                score[index-1]=previous;
            }
            if(dartResult[i]=='#') {
                temp*=-1;
            }
            continue;
        }
    }
    score[index]=temp;
    
    for(let i=1;i<score.length;i++){
         answer+=Number(score[i]);
    }
    
    console.log(score[-1])
    return answer;
}
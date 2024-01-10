function solution(n, left, right) {
    var answer = [];
    
    let s_row = Math.floor(left/n+1);
    let s_col = left%n+1;
    //let e_row = right/n+1;
    //let e_col = right%n+1;
    
    for(let i=0;i<right-left+1;i++){
        if(s_row>=s_col){
            answer.push(s_row);
        }else{
            answer.push(s_col);
        }
        if(s_col==n){
            s_col=1;
            s_row++;
        }else{
            s_col++;
        }
    }
    
    
    return answer;
}
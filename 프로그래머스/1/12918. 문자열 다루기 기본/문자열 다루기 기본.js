function solution(s) {
    let answer=false;
    
    if((s.length == 4 || s.length == 6) && parseInt(s) == s ){
      answer=true;
    }
    return answer;
}
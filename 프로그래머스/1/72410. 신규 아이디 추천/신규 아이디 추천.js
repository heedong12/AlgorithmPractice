function solution(new_id) {
    var answer = [];
    const notAllowChar='~!@#$%^&*()=+[{]}:?,<>/'.split('')
    
    // 1단계
    new_id = new_id.toLowerCase()
   
    for(const item of new_id){
        // 2단계
        if(!notAllowChar.includes(item)) {
            answer.push(item)
        }
        
        // 3단계
        if(item === '.' && answer.length > 1 && answer[answer.length-2]==='.') {
            answer.splice(-1,1)
        }
        
    }
    
      // 4단계
        if(answer[0]==='.'){
            answer.splice(0,1)
        }
        if(answer[answer.length-1]==='.'){
            answer.splice(-1,1)
        }
        
    
     // 5단계
        if(answer.length === 0){
            answer.push('a')
        }
        
        // 6단계
        if(answer.length >= 16){
            answer.splice(15)
            if(answer[answer.length-1]==='.'){
                answer.splice(-1,1)
            }
        }
        
        // 7단계
        if(answer.length <= 2){
            while(answer.length!=3){
                answer.push(answer[answer.length-1])
            }
        }

    return answer.join('');
}
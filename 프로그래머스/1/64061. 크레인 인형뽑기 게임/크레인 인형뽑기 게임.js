function solution(board, moves) {
    var answer = 0;
    const stack = []
    
    
    
    for(const move of moves){
        for(let i=0;i<board.length;i++){
            let temp=board[i][move-1]
            if(temp===0) continue;
            else {
                if(stack.length>0 && stack[stack.length-1]===temp){
                    stack.pop()
                    answer+=2;
                    board[i][move-1]=0
                    break;
                } else {
                    stack.push(temp)
                    board[i][move-1]=0
                    break;

                }
           
            }
        }
    }
    
    
    return answer;
}
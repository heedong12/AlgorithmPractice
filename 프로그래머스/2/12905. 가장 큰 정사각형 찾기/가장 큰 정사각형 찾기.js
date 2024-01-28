function solution(board)
{
    var answer = 0;
    
    let row = board.length;
    let col = board[0].length;
    
    if(board[0][0]==1 || board[0][1]==1 || board[1][0]==1) answer=1;
    
    for(let j=1;j<col;j++){
        for(let i=1;i<row;i++){
            if(board[i][j]!=0 && board[i][j-1]!=0 && board[i-1][j]!=0 && board[i-1][j-1]!=0){
                board[i][j] = Math.min(board[i][j-1],board[i-1][j],board[i-1][j-1])+1;
            }
            answer = Math.max(board[i][j],answer);
        }
    }

    return answer*answer;
}
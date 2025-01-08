function solution(lottos, win_nums) {
    
//     const min = lottos.filter(n => win_nums.includes(n)).length;
//     const max = lottos.filter(n => n === 0).length + min;
    var answer = new Array(2)
    let zeroNum = 0
    let lowScore = 7
    
    lottos.forEach(item => {
        if(item === 0){
            zeroNum++
        }
        if(item!==0 && win_nums.includes(item)){
            lowScore--;
            win_nums.splice(win_nums.indexOf(item),1)
        }
    })
   
    answer[1]=lowScore === 7 ? 6 : lowScore
    lowScore = zeroNum >= win_nums.length ? 1 : lowScore-zeroNum
    answer[0]=lowScore === 7 ? 6 : lowScore

    
    return answer;
}
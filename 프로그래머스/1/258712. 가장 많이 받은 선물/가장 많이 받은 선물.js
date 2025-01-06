function solution(friends, gifts) {
   
    const friendsNum = friends.length
    const answer = new Array(friendsNum).fill(0)
    const friendsInfo = new Map()
    const giftList = new Array(friendsNum).fill(0).map(_ => new Array(friendsNum).fill(0))
    const giftScore = new Array(friendsNum).fill(0)
    
          
    friends.forEach((item,idx)=>{
        friendsInfo.set(item,idx)
    })
    
    gifts.forEach(item => {
        const [from, to] = item.split(' ')
        giftList[friendsInfo.get(from)][friendsInfo.get(to)]++
        giftScore[friendsInfo.get(from)]++
        giftScore[friendsInfo.get(to)]--
    })
    
    for(let i=0;i<friendsNum;i++){
        for(let j=i;j<friendsNum;j++){
            if(i===j) continue;
            
            if(giftList[i][j] > giftList[j][i]){
                answer[i]++
                continue;
            } 
             if(giftList[i][j] < giftList[j][i]){
                answer[j]++
                continue;
            } 

            
            if(giftList[i][j] === giftList[j][i]){
                if(giftScore[i]===giftScore[j]){
                    continue;
                }
                giftScore[i] > giftScore[j] ? answer[i]++ : answer[j]++
            }
        }
    }
    

    console.log('giftScore : ' + giftScore)
    console.log('answer : ' + answer)
    return Math.max(...answer);
}
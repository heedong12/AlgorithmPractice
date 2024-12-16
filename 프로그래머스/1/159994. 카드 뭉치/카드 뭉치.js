function solution(cards1, cards2, goal) {
    let cards1Idx = 0;
    let cards2Idx = 0;
    
    for (let item of goal) {
        if (cards1[cards1Idx] === item) {
            cards1Idx++;
        } else if (cards2[cards2Idx] === item) {
            cards2Idx++;
        } else {
            return 'No'; 
        }
    }
    
    return 'Yes';
}

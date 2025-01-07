function solution(players, callings) {

    const map = new Map()

    players.forEach((item,idx)=>{
        map.set(item, idx)
    })
    
    callings.forEach((item)=>{
        const idx =  map.get(item)
        const frontName = players[idx-1]
        
        players[idx]=frontName
        players[idx-1]=item
        
        map.set(frontName, idx)
        map.set(item, idx-1)
        
    })
    
    return players
}
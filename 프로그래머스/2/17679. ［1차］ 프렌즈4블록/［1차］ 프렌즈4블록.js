function solution(m, n, board) {
    var answer = 0;
    let maps = Array.from({length:n},() => Array(m).fill(""))
    board.forEach((map,idx)=>{
        map.split("").forEach((item,index)=>{
            maps[n-1-index][idx]=item
        })
    })

    const searchBlock = (i,j) => {
        let item = maps[i][j]
        let findBlock = []
        
        if(item==="") return findBlock
        if(maps[i+1][j]===item && maps[i][j+1]===item && maps[i+1][j+1]===item){
            findBlock.push(`${i},${j}`)
            findBlock.push(`${i},${j+1}`)
            findBlock.push(`${i+1},${j}`)
            findBlock.push(`${i+1},${j+1}`)
        }
        return findBlock;
    }

    while(true){
        let result = new Set();
        for(let i=0;i<n-1;i++){
            for(let j=0;j<m-1;j++){
               let temp = searchBlock(i,j)
               if(temp.length > 0){
                   temp.forEach((item)=>{
                       result.add(item)
                   })
               }
            }
        }
        
        if(result.size === 0) break;
        answer+=result.size
        
        result.forEach((item)=>{
            let [i,j]=item.split(",").map(Number)
            maps[i][j]=""
        })
        
       maps = maps.map((item,idx)=>{
           let temp = []
           item.forEach((map,index)=>{
               if(map==="") temp.unshift("")
               else temp.push(map)
           })
           return temp;
        })
        

    }
    
    return answer;
}
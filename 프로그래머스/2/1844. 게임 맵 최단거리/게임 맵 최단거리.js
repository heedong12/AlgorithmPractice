function solution(maps) {
    var answer = 0;
    const n = maps[0].length    // 열 -> x
    const m = maps.length       // 행 -> y

    // const visited = new Array(m).fill(false).map(_ => new Array(n).fill(false))
    const visited = Array.from({length:m}, ()=> Array(n).fill(false))
    const checkXY = (x,y) => {
        if(x<0 || x>=n || y<0 || y>=m || visited[y][x] || maps[y][x]===0) return false;
        return true;
    }
        
    const move = [[-1,0],[1,0],[0,-1],[0,1]]
    
    const bfs = () => {
        let queue = [[0,0,1]]   // x, y, count
        visited[0][0]=true
        
        while(queue.length > 0){
            let [x,y,count] = queue.shift();
            
            if(x === n-1 && y === m-1) return count
            
            for(const [dx,dy] of move){
                let nx = dx+x
                let ny = dy+y
                
                if(checkXY(nx,ny)){
                    visited[ny][nx]=true
                    queue.push([nx, ny, count+1])
                }
            } 
        }

        return -1;
    }
    
    return bfs();
}
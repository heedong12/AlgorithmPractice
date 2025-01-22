function solution(maps) {
    let dy = [-1, 1, 0, 0];
    let dx = [0, 0, -1, 1];
    let start = [-1, -1];
    let end = [-1, -1];
    let lever = [-1, -1];
    

    maps = maps.map((item, idx) => {
        let map = item.split("");
        if (map.includes("S")) {
            start = [map.indexOf("S"), idx];
        }
        if (map.includes("E")) {
            end = [map.indexOf("E"), idx];
        }
        if (map.includes("L")) {
            lever = [map.indexOf("L"), idx];
        }
        return map;
    });
 

    const checkIsValid = (x, y) => {
        if (x < 0 || x >= maps[0].length || y < 0 || y >= maps.length || maps[y][x] === 'X') return false;
        return true;
    };


    const BFS = (start, end) => {
        let queue = [[...start, 0]]; 
        let visited = Array.from({ length: maps.length }, () => new Array(maps[0].length).fill(false));
        visited[start[1]][start[0]] = true;

        while (queue.length > 0) {
            let [x, y, count] = queue.shift();

            if (x === end[0] && y === end[1]) return count;

            for (let i = 0; i < 4; i++) {
                let nx = dx[i] + x;
                let ny = dy[i] + y;
                if (checkIsValid(nx, ny) && !visited[ny][nx]) {
                    visited[ny][nx] = true;
                    queue.push([nx, ny, count + 1]);
                }
            }
        }
        return -1;
    };

    let toLever = BFS(start, lever); 
    if (toLever === -1) return -1;

    let toEnd = BFS(lever, end); 
    if (toEnd === -1) return -1;

    return toLever + toEnd;
}

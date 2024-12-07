function solution(dirs) {
    let x = 0;
    let y = 0;

    let visited = {};
    
    for (const dir of dirs) {
        let dx = x;
        let dy = y;

        switch (dir) {
            case 'U':
                dy += 1;
                break;
            case 'D':
                dy -= 1;
                break;
            case 'L':
                dx -= 1;
                break;
            case 'R':
                dx += 1;
                break;
        }

        if (dx < -5 || dx > 5 || dy < -5 || dy > 5) {
            continue; 
        }

        const path1 = `${x},${y}>${dx},${dy}`;
        const path2 = `${dx},${dy}>${x},${y}`;
        if (!visited[path1]) {
            visited[path1] = true;
            visited[path2] = true; 

        }

        x = dx;
        y = dy;
    }

    return Object.keys(visited).length/2;
}

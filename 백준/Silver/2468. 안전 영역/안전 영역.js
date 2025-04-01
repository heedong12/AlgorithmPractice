let [N, ...maps] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

N = Number(N);
let maxHeight = 0;
const map = maps.map((item) =>
  item.split(" ").map((num) => {
    maxHeight = Math.max(maxHeight, Number(num));
    return Number(num);
  })
);

let max = 1;

// 상하좌우
const dx = [0, 0, -1, 1];
const dy = [-1, 1, 0, 0];

const bfs = (x, y, visited, limit) => {
  const queue = [[x, y]];
  visited[y][x] = true;

  while (queue.length > 0) {
    const [cx, cy] = queue.shift();

    for (let i = 0; i < 4; i++) {
      const nx = cx + dx[i];
      const ny = cy + dy[i];

      if (
        nx >= 0 &&
        nx < N &&
        ny >= 0 &&
        ny < N &&
        !visited[ny][nx] &&
        map[ny][nx] > limit
      ) {
        queue.push([nx, ny]);
        visited[ny][nx] = true;
      }
    }
  }
};

for (let i = 1; i <= maxHeight; i++) {
  let safeAreas = 0;
  let visited = Array.from({ length: N }, () => new Array(N).fill(false));

  for (let y = 0; y < N; y++) {
    for (let x = 0; x < N; x++) {
      if (map[y][x] > i && !visited[y][x]) {
        bfs(x, y, visited, i);
        safeAreas++;
      }
    }
  }

  max = Math.max(max, safeAreas);
}

console.log(max);

const [N, ...inputs] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n");

const arr = inputs.map((item) => item.split(" ").map(Number));
let minCost = Number.MAX_VALUE;

let answer = [];
const findMinCost = (cost, visited, start) => {
  if (visited.every((item) => item) && arr[start][0] > 0) {
    cost += arr[start][0];
    return (minCost = Math.min(minCost, cost));
  }

  for (let j = 1; j < N; j++) {
    if (start != j && !visited[j] && arr[start][j] > 0) {
      visited[j] = true;
      findMinCost(cost + arr[start][j], visited, j);
      visited[j] = false;
    }
  }
};

const visited = Array.from({ length: N }, (_) => false);
visited[0] = true;
findMinCost(0, visited, 0);

console.log(minCost);

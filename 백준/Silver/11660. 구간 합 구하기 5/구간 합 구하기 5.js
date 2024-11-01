const input = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n");

const [N, M] = input[0].split(" ").map(Number);
let arr = Array.from({ length: N + 1 }, () => Array(N + 1).fill(0));
for (let i = 1; i <= N; i++) {
  let temp = input[i].split(" ").map(Number);
  for (let j = 1; j <= N; j++) {
    arr[i][j] = temp[j - 1];
  }
}

let sumArr = Array.from({ length: N + 1 }, () => Array(N + 1).fill(0));
for (let i = 1; i <= N; i++) {
  for (let j = 1; j <= N; j++) {
    sumArr[i][j] =
      arr[i][j] + sumArr[i - 1][j] + sumArr[i][j - 1] - sumArr[i - 1][j - 1];
  }
}

for (let i = N + 1; i < input.length; i++) {
  let [x1, y1, x2, y2] = input[i].split(" ");

  let result =
    sumArr[x2][y2] -
    sumArr[x1 - 1][y2] -
    sumArr[x2][y1 - 1] +
    sumArr[Math.min(x1, x2) - 1][Math.min(y1, y2) - 1];

  console.log(result);
}

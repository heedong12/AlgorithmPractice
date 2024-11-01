const input = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n");

const [N, M] = input[0].split(" ").map(Number);

let sumArr = Array.from({ length: N + 1 }, () => Array(N + 1).fill(0));
for (let i = 1; i <= N; i++) {
  let row = input[i].split(" ").map(Number);
  for (let j = 1; j <= N; j++) {
    sumArr[i][j] =
      row[j - 1] + sumArr[i - 1][j] + sumArr[i][j - 1] - sumArr[i - 1][j - 1];
  }
}

let results = [];

for (let i = N + 1; i < input.length; i++) {
  let [x1, y1, x2, y2] = input[i].split(" ");
  results.push(
    sumArr[x2][y2] -
      sumArr[x1 - 1][y2] -
      sumArr[x2][y1 - 1] +
      sumArr[x1 - 1][y1 - 1]
  );
}

console.log(results.join("\n"));

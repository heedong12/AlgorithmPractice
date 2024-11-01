const input = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n");
const [N, X] = input[0].split(" ").map(Number);
const visitNum = input[1].split(" ").map(Number);

let sum = 0;
for (let i = 0; i < X; i++) {
  sum += visitNum[i];
}

let max = sum;
let count = 1;

for (let i = X; i < N; i++) {
  sum += visitNum[i] - visitNum[i - X];

  if (sum > max) {
    max = sum;
    count = 1;
  } else if (sum === max) {
    count++;
  }
}

console.log(max === 0 ? "SAD" : [max, count].join("\n"));

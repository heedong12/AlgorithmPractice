const input = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n");
const [N, X] = input[0].split(" ").map(Number);
const visitNum = input[1].split(" ").map(Number);
let maxNum = [];

let start = 0;
let end = start + X - 1;

let sum = 0;
for (let i = 0; i <= end; i++) {
  sum += Number(visitNum[i]);
}
maxNum.push(sum);
start++;
end++;

while (end < N) {
  maxNum.push(maxNum[start - 1] - visitNum[start - 1] + visitNum[end]);
  start++;
  end++;
}

let count = 0;
let max = Math.max(...maxNum);
maxNum.filter((item) => (item === max ? count++ : ""));

console.log(max === 0 ? "SAD" : max + "\n" + count);

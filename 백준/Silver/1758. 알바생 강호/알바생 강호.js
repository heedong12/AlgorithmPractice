const readFileSyncAddress = '/dev/stdin'    //제출시 활성화
const fs = require("fs");
//input에 입력값 저장
const [n, ...input] = fs
  .readFileSync(readFileSyncAddress, "utf-8")
  .trim()
  .split("\n");

let cost = 0;
input.sort(function (a, b) {
  return b - a;
});

for (let i = 0; i < n; i++) {
  if (input[i] - i > 0) {
    cost += input[i] - i;
  } else {
    break;
  }
}

console.log(cost);

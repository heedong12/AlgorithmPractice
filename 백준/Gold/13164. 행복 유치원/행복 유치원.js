const readFileSyncAddress = '/dev/stdin'    //제출시 활성화
const fs = require("fs");
//input에 입력값 저장
const input = fs.readFileSync(readFileSyncAddress, "utf-8").trim().split("\n");

const [N, K] = input[0].split(" ");
const arr = input[1].split(" ");
const dif = [];
for (let i = 1; i < arr.length; i++) {
  dif.push(arr[i] - arr[i - 1]);
}

dif.sort(function (a, b) {
  return a - b;
});

let cost = 0;
for (let i = 0; i < N - K; i++) {
  cost += dif[i];
}
console.log(cost);

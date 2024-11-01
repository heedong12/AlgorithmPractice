const [N, input] = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n");

const A = input.split(" ").map(Number);
let DP = new Array(Number(N)).fill(1); // DP 배열을 초기화

for (let i = 0; i < N; i++) {
  for (let j = 0; j < i; j++) {
    if (A[j] > A[i]) {
      // A[j]가 A[i]보다 크면
      DP[i] = Math.max(DP[i], DP[j] + 1); // DP[i] 업데이트
    }
  }
}

console.log(Math.max(...DP));

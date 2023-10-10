const readFileSyncAddress = '/dev/stdin'    //제출시 활성화
const fs = require("fs");
//input에 입력값 저장
const input = fs
  .readFileSync(readFileSyncAddress)
  .toString()
  .trim()
  .split("\n");

const [N, M, R] = input[0].split(" ");
const arr = input.slice(1, N + 1).map((line) => line.split(" ").map(Number));

//돌릴 사각형 개수(min(N,M) mod 2)
const count = Math.min(N, M) / 2;

for (let i = 0; i < R; i++) {
  for (let j = 0; j < count; j++) {
    let temp = arr[j][j];
    //아래
    // left
    for (let k = j; k < M - j - 1; k++) {
      arr[j][k] = arr[j][k + 1];
    }
    // up
    for (let k = j; k < N - 1 - j; k++) {
      arr[k][M - j - 1] = arr[k + 1][M - j - 1];
    }
    // right
    for (let k = M - j - 1; k > j; k--) {
      arr[N - 1 - j][k] = arr[N - 1 - j][k - 1];
    }
    // down
    for (let k = N - j - 1; k > j; k--) {
      arr[k][j] = arr[k - 1][j];
    }
    arr[j + 1][j] = temp;
  }
}

let answer = "";
arr.forEach((i) => {
  answer += i.join(" ") + "\n";
});
console.log(answer);

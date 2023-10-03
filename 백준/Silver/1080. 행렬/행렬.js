const readFileSyncAddress = '/dev/stdin'    //제출시 활성화
const fs = require("fs");
//input에 입력값 저장
const [n, ...input] = fs
  .readFileSync(readFileSyncAddress)
  .toString()
  .split("\n")
  .map((line) => line.trim());

const sol = (n, input) => {
  const [N, M] = n.split(" ");

  const arr = input.slice(0, N).map((line) => line.split("").map(Number));
  const answer = input.slice(N).map((line) => line.split("").map(Number));

  const compare = (arr, answer) => {
    for (let i = 0; i < N; i++) {
      for (let j = 0; j < M; j++) {
        if (arr[i][j] !== answer[i][j]) return false;
      }
    }
    return true;
  };

  if (compare(arr, answer)) return 0;

  const flip = (x, y) => {
    for (let i = x; i < x + 3; i++) {
      for (let j = y; j < y + 3; j++) {
        arr[i][j] = 1 - arr[i][j];
      }
    }
  };

  let count = 0;
  for (let i = 0; i < N - 2; i++) {
    for (let j = 0; j < M - 2; j++) {
      if (arr[i][j] !== answer[i][j]) {
        flip(i, j);
        count++;
        if (compare(arr, answer)) return count;
      }
    }
  }
  return -1;
};

console.log(sol(n, input));

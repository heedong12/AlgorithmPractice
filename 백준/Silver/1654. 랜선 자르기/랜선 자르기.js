const filePath = process.platform === "linux" ? "/dev/stdin" : "ex.txt";

const [A, ...B] = require("fs")
  .readFileSync(filePath)
  .toString()
  .trim()
  .split("\n");

const [K, N] = A.split(" ");

let start = 1;
let end = Math.max(...B);
let mid = Math.floor((start + end) / 2); //길이

while (start <= end) {
  let count = B.reduce((acc, cur) => acc + Math.floor(cur / mid), 0);

  if (count === N) {
    break;
  }
  if (count < N) {
    end = mid - 1;
  } else {
    start = mid + 1;
  }
  mid = Math.floor((start + end) / 2);
}

console.log(mid);

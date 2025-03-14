const [N, L, W, H] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split(" ")
  .map(Number);

let start = 0;
let end = Math.min(L, W, H);
let mid = 0;

for (let i = 0; i < 57; i++) {
  mid = (start + end) / 2;
  if (Math.floor(L / mid) * Math.floor(W / mid) * Math.floor(H / mid) < N)
    end = mid;
  else start = mid;
}

console.log(mid);

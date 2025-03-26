let [N, M, nums] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n");

N = Number(N);
M = Number(M);

nums = nums
  .split(" ")
  .map(Number)
  .sort((a, b) => a - b);

let start = 0;
let end = N - 1;
let count = 0;

while (start < end && end < N) {
  let sum = nums[start] + nums[end];

  if (sum === M) {
    count++;
    start++;
    end--;
  } else if (sum > M) end--;
  else if (sum < M) start++;
}
console.log(count);

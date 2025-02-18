const [nums, ...inputs] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n");

let [N, K] = nums.split(" ");
let count = 0;

for (let coin of inputs.reverse()) {
  let coinNum = Math.floor(K / coin);
  if (coinNum > 0) {
    K -= coinNum * coin;
    count += coinNum;
  }
}

console.log(count);

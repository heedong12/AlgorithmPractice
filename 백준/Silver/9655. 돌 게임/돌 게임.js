let N = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim();
console.log(N % 2 === 0 ? "CY" : "SK");

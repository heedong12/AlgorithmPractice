const filePath = process.platform === "linux" ? "/dev/stdin" : "ex.txt";

const [N, arr1, M, arr2] = require("fs")
  .readFileSync(filePath)
  .toString()
  .trim()
  .split("\n");

const set = new Set(arr1.split(" ").map(Number));
const arr = arr2.split(" ").map(Number);

const result = [];
arr.forEach((item) => {
  set.has(item) ? result.push(1) : result.push(0);
});

console.log(result.join("\n"));

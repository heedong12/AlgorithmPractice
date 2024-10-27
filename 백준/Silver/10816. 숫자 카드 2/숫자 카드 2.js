const filePath = process.platform === "linux" ? "/dev/stdin" : "ex.txt";

const [N, arr1, M, arr2] = require("fs")
  .readFileSync(filePath)
  .toString()
  .trim()
  .split("\n");

const A = new Map();
arr1
  .split(" ")
  .map(Number)
  .forEach((item) => {
    if (A.has(item)) {
      A.set(item, A.get(item) + 1);
    } else {
      A.set(item, 1);
    }
  });

const result = [];
arr2
  .split(" ")
  .map(Number)
  .forEach((item) => {
    if (A.has(item)) {
      result.push(A.get(item));
    } else {
      result.push(0);
    }
  });

console.log(result.join(" "));

let [string, bomb] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n");

let stack = [];
let n = bomb.length;

for (let s of string) {
  stack.push(s);

  if (stack.length >= n && stack.slice(-n).join("") === bomb) {
    stack.splice(-n);
  }
}
console.log(stack.length > 0 ? stack.join("") : "FRULA");

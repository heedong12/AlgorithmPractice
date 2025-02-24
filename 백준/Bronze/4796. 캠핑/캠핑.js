const inputs = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n");

const answer = [];

for (let i = 0; i < inputs.length - 1; i++) {
  let [L, P, V] = inputs[i].split(" ").map(Number);
  let rest = Math.floor(V / P);
  let addRest = Math.min(V - rest * P, L)

  answer.push(`Case ${i + 1}: ${rest * L + addRest}`);
}

console.log(answer.join("\n"));
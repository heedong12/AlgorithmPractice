const [T, ...inputs] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n");

for (let i = 0; i < inputs.length; i = i + 3) {
  let [N, M] = inputs[i].split(" ").map(Number);
  let A = inputs[i + 1]
    .split(" ")
    .map(Number)
    .sort((a, b) => a - b);
  let B = inputs[i + 2]
    .split(" ")
    .map(Number)
    .sort((a, b) => a - b);

  let idx = 0;
  let count = 0;

  for (let j = 0; j < N; j++) {
    while (idx < M) {
      if (A[j] > B[idx]) idx++;
      else break;
    }
    count += idx;
  }
  console.log(count);
}

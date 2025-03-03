const [T, ...inputs] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n")
  .map(Number);

for (let i = 0; i < inputs.length; i = i + 2) {
  let K = inputs[i];
  let N = inputs[i + 1];

  const dp = Array.from({ length: K + 1 }, () => new Array(N + 1));

  for (let j = 0; j < dp.length; j++) {
    for (let k = 0; k < dp[0].length; k++) {
      if (k <= 1) dp[j][k] = 1;
      else if (j === 0) dp[j][k] = k;
      else dp[j][k] = dp[j - 1][k] + dp[j][k - 1];
    }
  }
  console.log(dp[K][N]);
}
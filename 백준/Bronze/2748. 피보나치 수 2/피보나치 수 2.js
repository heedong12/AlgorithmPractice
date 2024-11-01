const input = require("fs").readFileSync("/dev/stdin").toString().trim();

const fibo = (num, memo) => {
  if (num === 1 || num === 2) return BigInt(1);
  if (memo[num]) return memo[num];
  memo[num] = fibo(num - 1, memo) + fibo(num - 2, memo);
  return memo[num];
};

const n = Number(input);
console.log(fibo(n, (memo = {})).toString());

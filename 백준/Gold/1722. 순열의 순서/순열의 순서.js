const [N, input] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n");

let [K, ...numbers] = input.split(" ").map(BigInt);
const NInt = BigInt(N);

const factorial = (n) => {
  if (n <= 1n) {
    return 1n;
  }
  return n * factorial(n - 1n);
};

const getKthPermutation = (N, K) => {
  let nums = Array.from({ length: Number(N) }, (_, i) => i + 1);
  let result = [];
  K--;

  for (let i = Number(N); i > 0; i--) {
    let fact = factorial(BigInt(i) - 1n);
    let index = Number(K / fact);
    result.push(nums[index]);
    nums.splice(index, 1);
    K %= fact;
  }
  console.log(result.join(" "));
};

const getPermutationIndex = (N, perm) => {
  let nums = Array.from({ length: Number(N) }, (_, i) => i + 1);
  let count = 0n;
  for (let i = 0; i < Number(N); i++) {
    let idx = nums.indexOf(Number(perm[i]));
    count += BigInt(idx) * factorial(NInt - BigInt(i) - 1n);
    nums.splice(idx, 1);
  }
  console.log(String(count + 1n));
};

if (K === 1n) {
  getKthPermutation(NInt, numbers[0]);
} else {
  getPermutationIndex(NInt, numbers);
}
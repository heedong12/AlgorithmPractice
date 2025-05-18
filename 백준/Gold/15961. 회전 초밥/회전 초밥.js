let [Ndkc, ...sushis] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n");

let [N, d, k, c] = Ndkc.split(" ").map(Number);
sushis = sushis.map(Number);

let start = 0;
let end = k;
let map = new Map();

for (let i = 0; i < k; i++) {
  map.set(sushis[i], (map.get(sushis[i]) ?? 0) + 1);
}
map.set(c, (map.get(c) ?? 0) + 1);

let max = map.size;

while (start < N) {
  // 첫번째꺼 제거
  let startTarget = start % N;
  if (map.has(sushis[startTarget])) {
    if (map.get(sushis[startTarget]) === 1) map.delete(sushis[startTarget]);
    else map.set(sushis[startTarget], map.get(sushis[startTarget]) - 1);
  }
  // 마지막 추가
  let endTarget = end % N;
  map.set(sushis[endTarget], (map.get(sushis[endTarget]) ?? 0) + 1);

  max = Math.max(map.size, max);
  start++;
  end++;
}

console.log(max);

const [num, ...maps] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n");

const [N, M, B] = num.split(" ").map(Number);
let maxHeight = 0;
let minheight = 256;

const arr = maps.map((item) => {
  let map = item.split(" ").map(Number);
  maxHeight = Math.max(...map, maxHeight);
  minheight = Math.min(...map, minheight);
  return map;
});

let time = Number.MAX_VALUE;
let height = 0;
for (let i = minheight; i <= maxHeight; i++) {
  let add = 0;
  let remove = 0;

  for (let j = 0; j < N; j++) {
    for (let k = 0; k < M; k++) {
      // 목표 높이보다 작음 -> 쌓아야됨
      if (arr[j][k] < i) add += i - arr[j][k];
      else if (arr[j][k] > i) remove += arr[j][k] - i;
    }
  }

  if (B - add + remove >= 0 && time >= add + remove * 2) {
    if (time === add + remove * 2) height = Math.max(height, i);
    else height = i;
    time = add + remove * 2;
  }
}

console.log(time + " " + height);

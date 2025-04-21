let [NMK, ...infos] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n");

const Directions = [
  [-1, 0], [-1, 1], [0, 1], [1, 1],
  [1, 0], [1, -1], [0, -1], [-1, -1],
];

const [N, _, K] = NMK.split(" ").map(Number);

// 초기 파이어볼 리스트
let fireballs = infos.map((line) => {
  const [r, c, m, s, d] = line.split(" ").map(Number);
  return { r: r - 1, c: c - 1, m, s, d };
});

// wrap-around 계산 그대로 유지
const calcRC = (r, c, s, d) => {
  let [dr, dc] = Directions[d];
  let nr = ((r + dr * s) % N + N) % N;
  let nc = ((c + dc * s) % N + N) % N;
  return [nr, nc];
};

for (let i = 0; i < K; i++) {
  // 2차원 배열 map 초기화
  let map = Array.from({ length: N }, () => Array.from({ length: N }, () => []));

  // 1. 파이어볼 이동
  for (const fb of fireballs) {
    const [nr, nc] = calcRC(fb.r, fb.c, fb.s, fb.d);
    map[nr][nc].push({ r: nr, c: nc, m: fb.m, s: fb.s, d: fb.d });
  }

  // 2. 이동 후 처리
  fireballs = [];

  for (let r = 0; r < N; r++) {
    for (let c = 0; c < N; c++) {
      const cell = map[r][c];
      const len = cell.length;

      if (len === 0) continue;

      if (len === 1) {
        fireballs.push(cell[0]);
        continue;
      }

      let totalM = 0, totalS = 0;
      let isEven = true, isOdd = true;

      for (const { m, s, d } of cell) {
        totalM += m;
        totalS += s;
        if (d % 2 === 0) isOdd = false;
        else isEven = false;
      }

      const newM = Math.floor(totalM / 5);
      if (newM === 0) continue;

      const newS = Math.floor(totalS / len);
      const dirs = (isEven || isOdd) ? [0, 2, 4, 6] : [1, 3, 5, 7];

      for (const d of dirs) {
        fireballs.push({ r, c, m: newM, s: newS, d });
      }
    }
  }
}

// 결과 계산
let answer = fireballs.reduce((sum, fb) => sum + fb.m, 0);
console.log(answer);

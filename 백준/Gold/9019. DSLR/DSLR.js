let [T, ...arr] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

const D = (num) => (2 * num) % 10000;
const S = (num) => (num === 0 ? 9999 : num - 1);
const L = (num) => {
  return Number((num % 1000) * 10 + Math.floor(num / 1000));
};
const R = (num) => {
  return Number((num % 10) * 1000 + Math.floor(num / 10));
};
const METHODS = new Map([
  ["D", D],
  ["S", S],
  ["L", L],
  ["R", R],
]);

let answers = [];
const bfs = (A, B) => {
  // 숫자와 명령어 저장
  let visited = new Array(10000).fill(false);
  const queue = [[A, ""]];
  visited[A] = true;
  let answer = "";

  while (queue.length > 0) {
    let [num, command] = queue.shift();

    if (num === B) {
      answer = command;
      break;
    }

    for (let [string, func] of METHODS) {
      let result = func(num);
      if (!visited[result]) {
        visited[result] = true;
        queue.push([result, command + string]);
      }
    }
  }
  return answer;
};

for (let i = 0; i < Number(T); i++) {
  let [A, B] = arr[i].split(" ").map(Number);
  answers.push(bfs(A, B));
}

console.log(answers.join("\n"));

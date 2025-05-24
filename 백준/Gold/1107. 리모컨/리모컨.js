let [N, ...inputs] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n");

let buttons = [];

if (inputs.length === 2) {
  buttons = inputs[1].split(" ");
}

let cur = 100;

let canBtn = ["0", "1", "2", "3", "4", "5", "6", "7", "8", "9"].filter(
  (num) => !buttons.includes(num)
);
let min = Math.abs(+N - cur);
const findNum = (num) => {
  if (num.length > N.length + 1) return;
  if (num.length > 0) {
    const pressCount = num.length + Math.abs(+num - +N);
    min = Math.min(min, pressCount);
  }

  for (let i = 0; i < canBtn.length; i++) {
    findNum(num + canBtn[i]);
  }
};

if (+N === 100) {
  console.log(0);
} else {
  findNum("");
  console.log(min);
}

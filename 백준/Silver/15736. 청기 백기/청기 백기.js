const readFileSyncAddress = '/dev/stdin'    //제출시 활성화
const fs = require("fs");
//n은 버퍼의 크기
const n = fs.readFileSync(readFileSyncAddress).toString().trim();

let num = 1;

while (num ** 2 <= n) {
  num++;
}
console.log(num - 1);

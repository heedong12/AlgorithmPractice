
//readline 모듈 가져옴
const readline = require("readline");
//입출력을 위한 인터페이스 생성
const reader = readline.createInterface({
  input: process.stdin, //제출시 활성화
  output: process.stdout,
});
//입력 저장
let input = [];
//.이 들어오면 종료, 아니면 input 배열에 넣어줌
reader.on("line", function (line) {
  if (line === ".") {
    reader.close();
  } else {
    input.push(line);
  }
});

reader.on("close", function () {
  for (let i = 0; i < input.length; i++) {
    if (isBalance(input[i])) {
      console.log("yes");
    } else {
      console.log("no");
    }
  }
});

function isBalance(statement) {
  let stack = [];
  for (let i = 0; i < statement.length; i++) {
    if (statement[i] == "(" || statement[i] == "[") {
      stack.push(statement[i]);
    }
    if (statement[i] == ")" || statement[i] == "]") {
      //스택이 비어있으면 false
      if (stack.length == 0) {
        return false;
      }
      let temp = stack.pop();
      if (statement[i] == ")" && temp !== "(") {
        return false;
      }
      if (statement[i] == "]" && temp !== "[") {
        return false;
      }
    }
  }
  return stack.length == 0;
}

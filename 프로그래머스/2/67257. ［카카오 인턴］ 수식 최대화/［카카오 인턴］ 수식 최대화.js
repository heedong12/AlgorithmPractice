function solution(expression) {
  var answer = 0;
  let exp = [];
  let num = [];
  let temp = "";
  let com = [
    ["+", "-", "*"],
    ["+", "*", "-"],
    ["-", "+", "*"],
    ["-", "*", "+"],
    ["*", "+", "-"],
    ["*", "-", "+"],
  ];

  for (let e of expression) {
    if (e == "+" || e == "-" || e == "*") {
      exp.push(e);
      num.push(temp);
      temp = "";
    } else {
      temp += e;
    }
  }
  num.push(temp);
  console.log(num, exp);

  for (let combination of com) {
    let numArray = num.slice();
    let expArray = exp.slice();
    for (let op of combination) {
      while (expArray.includes(op)) {
        let idx = expArray.indexOf(op);
        if (op == "+")
          numArray[idx] = parseInt(numArray[idx]) + parseInt(numArray[idx + 1]);
        if (op == "-")
          numArray[idx] = parseInt(numArray[idx]) - parseInt(numArray[idx + 1]);
        if (op == "*")
          numArray[idx] = parseInt(numArray[idx]) * parseInt(numArray[idx + 1]);
        numArray.splice(idx + 1, 1);
        expArray.splice(idx, 1);
      }
    }
    answer = Math.max(answer, Math.abs(numArray[0]));
  }

  return answer;
}


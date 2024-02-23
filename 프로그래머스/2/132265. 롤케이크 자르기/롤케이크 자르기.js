function solution(topping) {
  var answer = 0;
  const len = topping.length;
  const frontCnt = Array(len).fill(0);
  const backCnt = Array(len).fill(0);

  const frontSet = new Set();
  const backSet = new Set();

  for (let i = 0; i < len; i++) {
    frontSet.add(topping[i]);
    backSet.add(topping[len - 1 - i]);
    frontCnt[i] = frontSet.size;
    backCnt[len - 1 - i] = backSet.size;
  }

  for (let i = 0; i < len - 1; i++) {
    if (frontCnt[i] === backCnt[i + 1]) answer++;
  }

  return answer;
}

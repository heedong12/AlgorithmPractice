function solution(today, terms, privacies) {
  var answer = [];
  let day = today.split(".").map(Number);
  let tDay = (day[0] - 2000) * 12 * 28 + day[1] * 28 + day[2];

  for (let i = 0; i < privacies.length; i++) {
    let temp = privacies[i].split(/\.| /);
    let pDay =
      (Number(temp[0]) - 2000) * 12 * 28 +
      Number(temp[1]) * 28 +
      Number(temp[2]);
    let term = terms.find((e) => e[0] == temp[3]);
    let month = term.split(" ");
    pDay += Number(month[1]) * 28;

    if (pDay <= tDay) {
      answer.push(i + 1);
    }
  }
  return answer;
}
function solution(s) {
  var answer = s.length;

  for (let i = 1; i <= Math.floor(s.length / 2); i++) {
    let result = "";
    let count = 1;
    let temp = s.slice(0, i);

    for (let j = i; j < s.length; j += i) {
      const current = s.slice(j, j + i);

      if (temp === current) {
        count++;
      } else {
        result += (count > 1 ? count : "") + temp;
        temp = current;
        count = 1;
      }
    }

    result += (count > 1 ? count : "") + temp;
    answer = Math.min(answer, result.length);
  }

  return answer;
}

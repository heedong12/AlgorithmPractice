function solution(k, ranges) {
  var answer = [];
  let area = [];
  let count = 0;
  while (k != 1) {
    let temp = k;
    k = k % 2 == 0 ? k / 2 : k * 3 + 1;
    area.push(parseFloat((temp + k) / 2));
    count++;
  }
  ranges.map((range) => {
    range[1] = count + range[1];
    if (range[0] > range[1]) return answer.push(-1);
    let sum = 0;
    for (let i = range[0]; i < range[1]; i++) {
      sum += area[i];
    }
    return answer.push(sum);
  });

  return answer;
}

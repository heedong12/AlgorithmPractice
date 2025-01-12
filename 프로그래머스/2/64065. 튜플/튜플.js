function solution(s) {
  var answer = [];
    
  s = s
    .replaceAll("{", "")
    .slice(0, -2)
    .split("},")
    .map((num) => num.split(","))
    .sort((a, b) => {
      return a.length - b.length;
    })
    .map((item) => {
      item.map((num) => {
        if (!answer.includes(Number(num))) answer.push(Number(num));
      });
    });

  return answer;
}

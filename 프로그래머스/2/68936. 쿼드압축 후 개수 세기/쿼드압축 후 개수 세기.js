function solution(arr) {
  var answer = [0, 0];

  const isOneNumber = (num1, num2, num3, num4) => {
    const arr = [num1, num2, num3, num4];
    if (arr.every((item) => item === num1)) {
      return num1;
    } else {
      answer[num1]++;
      answer[num2]++;
      answer[num3]++;
      answer[num4]++;
      return -1;
    }
  };

  let map = JSON.parse(JSON.stringify(arr));

  while (map.length > 1) {
    let newMap = Array.from({ length: map.length / 2 }, () =>
      new Array(map.length / 2).fill(0)
    );
    for (let i = 0; i < map.length; i += 2) {
      for (let j = 0; j < map.length; j += 2) {
        newMap[i / 2][j / 2] = isOneNumber(
          map[i][j],
          map[i + 1][j],
          map[i][j + 1],
          map[i + 1][j + 1]
        );
      }
    }
    map = newMap;
  }

  if (map[0][0] === 0 || map[0][0] === 1) {
    answer[map[0][0]]++;
  }

  return answer;
}

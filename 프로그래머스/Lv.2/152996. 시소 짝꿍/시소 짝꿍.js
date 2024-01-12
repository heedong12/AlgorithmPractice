function solution(weights) {
  var answer = 0;
  const map = new Map();
  //가능한 비율은 4가지뿐임
  const ratio = [1, 3 / 2, 2, 4 / 3];

  weights
    .sort((a, b) => b - a) //weights 내림차순 정렬
    .forEach((w) => {
      //weights 순회하면서 비율 r 곱해줌
      ratio.forEach((r) => {
        //map에 w*r인 key값이 존재하면, value 가져와서 answer에 더해줌
        if (map.has(w * r)) answer += map.get(w * r);
      });
      //map에 넣기(이미 map에 존재하면 value+1, 존재하지 않으면 1)
      map.set(w, (map.get(w) || 0) + 1);
    });

  return answer;
}

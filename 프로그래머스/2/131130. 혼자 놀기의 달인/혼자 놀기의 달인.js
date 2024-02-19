function solution(cards) {
  let answer = 0;
  let visit = Array(cards.length).fill(false);
  let box = [];

  for (let i = 0; i < cards.length; i++) {
    if (visit[i]) continue;

    if (visit[i] == false) {
      let temp = i;
      let count = 0;

      do {
        visit[temp] = true;
        temp = cards[temp]-1;
        count++;
      } while (temp !== i);
      box.push(count);
    }
  }

  box.sort((a, b) => {
    return b - a;
  });

  answer = box.length == 1 ? 0 : box[0] * box[1];
  return answer;
}

solution([8, 6, 3, 7, 2, 5, 1, 4]);

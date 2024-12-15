function solution(n, k, cmd) {
  const trash = [];

  const up = [...new Array(n + 2)].map((_, i) => i - 1);
  const down = [...new Array(n + 2)].map((_, i) => i + 1);
  k++
  for (const c of cmd) {
    if (c[0] === "U" || c[0] === "D") {
      let [upOrDown, num] = c.split(" ");
      if (upOrDown === "U") {
        for (let i = 0; i < num; i++) {
          k = up[k];
        }
      } else {
        for (let i = 0; i < num; i++) {
          k = down[k];
        }
      }
    } else if (c === "C") {
      trash.push(k);
      up[down[k]] = up[k];
      down[up[k]] = down[k];
      k = n < down[k] ? up[k] : down[k];
    } else {
      let top = trash.pop();
      down[up[top]] = top;
      up[down[top]] = top;
    }
  }

  const answer = new Array(n).fill("O");
  for (let i of trash) {
    answer[i - 1] = "X";
  }

  return answer.join("");
}

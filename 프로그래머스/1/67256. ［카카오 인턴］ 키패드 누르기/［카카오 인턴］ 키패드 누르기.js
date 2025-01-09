function solution(numbers, hand) {
  var answer = "";

const keypads = {
  1: [0, 0], 2: [0, 1], 3: [0, 2],
  4: [1, 0], 5: [1, 1], 6: [1, 2],
  7: [2, 0], 8: [2, 1], 9: [2, 2],
  0: [3, 1]
};

  let curLeft = [3, 0];
  let curRight = [3, 2];

  numbers.forEach((item, idx) => {
    const [goalX, goalY] = keypads[item];

    if ([1,4,7].includes(item)) {
      answer += "L";
      curLeft = keypads[item];
    } else if ([3,6,9].includes(item)) {
      answer += "R";
      curRight = keypads[item];
    } else {
      const [curLeftX, curLeftY] = curLeft;
      const [curRightX, curRightY] = curRight;

      let moveLeftNum = Math.abs(goalX - curLeftX) + Math.abs(goalY - curLeftY);
      let moveRightNum =
        Math.abs(goalX - curRightX) + Math.abs(goalY - curRightY);

      if (moveLeftNum < moveRightNum) {
        answer += "L";
        curLeft = keypads[item];
      } else if (moveLeftNum > moveRightNum) {
        answer += "R";
        curRight = keypads[item];
          console.log(item)
      } else {
        if (hand === "left") {
          answer += "L";
          curLeft = keypads[item];
        } else {
          answer += "R";
          curRight = keypads[item];
        }
      }
    }
  });

  return answer;
}

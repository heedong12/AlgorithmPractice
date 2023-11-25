function solution(fees, records) {
  var answer = [];
  var car = [];
  for (let r of records) {
    //시각, 차량번호, 내역
    var temp = r.split(" ");
    var index = car.findIndex((e) => e[0] == temp[1]);
    var time = temp[0].split(":");
    var changeT = Number(time[0]) * 60 + Number(time[1]);
    if (index == -1) {
      //등록된 차량 없음
      car.push([temp[1], changeT]);
    } else {
      car[index].push(changeT);
    }
  }

  car.sort((a, b) => {
    return a[0] - b[0];
  });

  for (let c of car) {
    var sumT = 0;
    for (let i = 1; i < c.length; i = i + 2) {
      if (i + 1 == c.length) {
        //출차 기록 없음
        sumT += 1439 - c[i];
      } else {
        //출차 기록 있음
        sumT += c[i + 1] - c[i];
      }
    }
    if (sumT <= fees[0]) {
      answer.push(fees[1]);
    } else {
      var a = fees[1];
      sumT -= fees[0];
      sumT = Math.ceil(sumT / fees[2]);
      a += sumT * fees[3];
      answer.push(a);
    }
  }
  return answer;
}
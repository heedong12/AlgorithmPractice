function solution(want, number, discount) {
  var answer = 0;
  let map = new Map();

  //map에 key:원하는 제품, value: 수량 저장
  for (let i = 0; i < want.length; i++) {
    map.set(want[i], number[i]);
  }
  //1일~10일 
  //할인하는 제품이 있으면 map에서 가져와서 value-1 시켜줌
  for (let i = 0; i < 10; i++) {
    if (map.has(discount[i])) {
      map.set(discount[i], map.get(discount[i]) - 1);
    }
  }
  //endDay = 마지막 날 저장(10일 -> 인덱스이므로 9 저장)
  let endDay = 9;

  for (let i = 0; endDay < discount.length; i++) {
    let flag = true;  
    //map의 모든 value를 검사 -> 0보다 큰 값이 존재하면 가능한 날 아님
    for (let value of map.values()) {
      if (value > 0) {
        flag = false;   
        break;
      }
    }
    if (flag) answer++; // 모든 value가 0 이하이므로 가능한 날임
    if (map.has(discount[i])) {   //첫째날 제외(map의 value+1)
      map.set(discount[i], map.get(discount[i]) + 1);
    }
    endDay++; //마지막 날 + 1
    if (map.has(discount[endDay])) {  //마지막 날에 할인하는 상품이 존재하면 value-1
      map.set(discount[endDay], map.get(discount[endDay]) - 1);
    }
  }

  return answer;
}

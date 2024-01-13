function solution(want, number, discount) {
  var answer = 0;
  let map = new Map();

  for (let i = 0; i < want.length; i++) {
    map.set(want[i], number[i]);
  }

  for (let i = 0; i < 10; i++) {
    if (map.has(discount[i])) {
      map.set(discount[i], map.get(discount[i]) - 1);
    }
  }

  let endDay = 9;
    for(let i=0;endDay<discount.length;i++){
        let flag=true;
        for(let value of map.values()){
            if(value > 0) {
                flag=false;
                break;
            }
        }
        if(flag) answer++;
        if(map.has(discount[i])){
            map.set(discount[i],map.get(discount[i])+1);
        }
        endDay++;
        if(map.has(discount[endDay])){
            map.set(discount[endDay],map.get(discount[endDay])-1);
        }
    }
 

  return answer;
}
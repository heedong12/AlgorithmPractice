function solution(n, lost, reserve) {
  var answer = n - lost.length;
  let arr = [];
    
  lost.sort();
  reserve.sort();

  for(let l of lost){
      if(reserve.includes(l)){
          answer+=1;
          reserve.splice(reserve.indexOf(l),1);
          arr.push(l);
      }
  }

    for(let a of arr){
        lost.splice(lost.indexOf(a),1);
    }
    
  for(let l of lost){
    if(reserve.includes(l-1)){
        answer+=1;
        reserve.splice(reserve.indexOf(l-1),1);
    } else if(reserve.includes(l+1)){
        answer+=1;
        reserve.splice(reserve.indexOf(l+1),1);
    }
  }
    
  return answer;
}

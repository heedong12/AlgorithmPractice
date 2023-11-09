function solution(a, b, n) {
  var answer = 0;
  var cola = n;

  while(cola>=a){   
    var q = Math.trunc(cola / a) * b; //받을 수 있는 콜라의 수
    var r = cola % a; //남는 콜라의 수
    cola = q + r;
    answer += q;
  }
    
  return answer;
}

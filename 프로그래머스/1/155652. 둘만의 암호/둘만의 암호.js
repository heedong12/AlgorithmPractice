function solution(s, skip, index) {
  var answer = "";

  let arr = Array.from({ length: 26 }, (v, i) => i + 1);
  for (let i = 0; i < skip.length; i++) {
    let temp = skip[i].charCodeAt() - 96;
    arr.splice(arr.indexOf(temp), 1);
  }

  for (let i = 0; i < s.length; i++) {
    let n = arr.indexOf(s[i].charCodeAt() - 96);

             n=(n+index)%arr.length;

    answer += String.fromCharCode(arr[n] + 96);
  }
  return answer;
}

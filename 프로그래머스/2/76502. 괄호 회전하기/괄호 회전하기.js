function solution(s) {
  var answer = 0;
  if (s.length % 2 != 0) {
    return answer;
  }

  for (let i = 0; i < s.length; i++) {
    let stack = [];
    let flag = true;
    for (let j = 0; j < s.length; j++) {
      if (s[j] == "(" || s[j] == "[" || s[j] == "{") {
        stack.push(s[j]);
      } else {
        if (stack.length == 0) {
          flag = false;
          break;
        }
        let open = stack.pop();
        if (
          !(open == "(" && s[j] == ")") &&
          !(open == "[" && s[j] == "]") &&
          !(open == "{" && s[j] == "}")
        ) {
          flag = false;
          break;
        }
      }
    }
    if (stack.length == 0 && flag) answer++;
     let temp=s.charAt(0);
     s=s.substring(1);
     s+=temp;
  }

  return answer;
}

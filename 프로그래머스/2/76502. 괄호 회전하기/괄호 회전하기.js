function solution(s) {
  const brackets = {
    "(": ")",
    "{": "}",
    "[": "]",
  };

  var answer = 0;
  if (s.length % 2 != 0) return answer;

  const string = s.split("");

  const isCorretString = (str) => {
    const stack = [];

    for (let char of str) {
      if (char === "(" || char === "[" || char === "{") {
        stack.push(char);
      } else {
        if (stack.length === 0) return false;
        const popElement = stack.pop();
        if (brackets[popElement] != char) {
          return false;
        }
      }
    }

    return stack.length === 0;
  };
  for (let i = 0; i < s.length; i++) {
    string.push(string.shift());
    if (isCorretString(string)) answer++;
  }
  return answer;
}

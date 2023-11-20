function solution(n, arr1, arr2) {
  var answer = [];

  for (let i = 0; i < n; i++) {
    var temp1 = arr1[i].toString(2);
    temp1 = temp1.length == n ? temp1 : temp1.padStart(n, "0");
    var temp2 = arr2[i].toString(2);
    temp2 = temp2.length == n ? temp2 : temp2.padStart(n, "0");
    var a = "";

    for (let j = 0; j < n; j++) {
      if (temp1[j] == temp2[j]) {
        a += temp1[j] == 1 ? "#" : " ";
      } else {
        a += "#";
      }
    }
    answer[i] = a;
  }
  return answer;
}

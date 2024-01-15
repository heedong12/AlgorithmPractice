function solution(progresses, speeds) {
  var answer = [];
  let day = [];
  for (let i = 0; i < progresses.length; i++) {
    progresses[i] = 100 - progresses[i];
    day[i] =
      progresses[i] % speeds[i] == 0
        ? progresses[i] / speeds[i]
        : Math.floor(progresses[i] / speeds[i]) + 1;
  }
    let temp = day[0];
    let count = 0;
    day.forEach((element)=>{
        if(temp >= element){
            count++;
        }
        if(temp < element){
            answer.push(count);
            count=1;
            temp=element;
        }
        
    })
    answer.push(count);
  return answer;
}
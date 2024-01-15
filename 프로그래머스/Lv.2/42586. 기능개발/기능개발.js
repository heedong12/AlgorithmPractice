function solution(progresses, speeds) {
  var answer = [];    
    let day = progresses.map((progresses,index) =>
            Math.ceil((100-progresses)/speeds[index]));
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
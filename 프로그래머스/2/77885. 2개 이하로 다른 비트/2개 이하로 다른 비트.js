function solution(numbers) {
   let answer = numbers.map((item)=>{
        if(item % 2 === 0){
          return item+1
        } else {
            let str ='0' + item.toString(2);
            let idx = str.lastIndexOf('01');
            str = str.substring(0,idx) + '10' + str.substring(idx+2, item.length);
            return parseInt(str,2)
        }
    })
    
    return answer;
}
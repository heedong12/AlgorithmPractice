function solution(survey, choices) {
    var answer = '';
    var test = [['R',0],['T',0],['C',0],['F',0],['J',0],['M',0],['A',0],['N',0]];
    
    for(let i=0;i<choices.length;i++){
        if(choices[i]<=3){  //choices가 1,2,3
            let index= test.findIndex(e => e[0]=== survey[i][0]);
            test[index][1]+=4-choices[i];
        }else if(choices[i]>=4){    //choices가 5,6,7
            let index= test.findIndex(e => e[0]=== survey[i][1]);            
            test[index][1]+=choices[i]-4;
        } 
    }
    
    for(let i =0;i<8;i=i+2){
        answer+= test[i][1]>=test[i+1][1] ? test[i][0] : test[i+1][0];
    }
    
    return answer;
}
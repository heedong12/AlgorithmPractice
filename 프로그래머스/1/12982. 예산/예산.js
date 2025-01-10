function solution(d, budget) {
    // var answer = 0;
    // let sum=0;
    // d.sort((a,b)=>a-b).forEach(item =>{
    //     sum+=item
    //     if(sum>budget) return;
    //     answer++
    // })
    
    return d.sort((a,b)=>a-b).reduce((acc,cur)=>{
        return acc += ((budget-=cur)>=0)
    },0)
}
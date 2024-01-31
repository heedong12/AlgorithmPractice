function solution(n) {
    var answer = Array.from(Array(n),() => new Array(n));
    let temp=0;
    let row=-1;
    let col=0;
    
    while(n>0){
        for(let i=0;i<n;i++) answer[++row][col]=++temp;           
        for(let i=0;i<n-1;i++) answer[row][++col]=++temp;
        for(let i=0;i<n-2;i++) answer[--row][--col]=++temp;
        n-=3;
    }
    let result = answer.flat().filter(value => value !== null);
    return result;
}
function solution(n, k) {
    const isPrime = (p) => {
        if(p==1) return false
        let num = 0
        for(let i=2;i<=Math.sqrt(p);i++){
           if(p % i === 0) {
               num++;
               break;
           }
        }
        return num===0;
    }
    
    const changeToK = () =>{
        let number = ""
        while(n>0){
            number+=n%k
            n= Math.floor(n/k)
        }
        return number.split("").reverse().join("");
    }

    let digitNum = changeToK().split("0").filter((item)=> item && !item.includes(0) && isPrime(item))
    

    return digitNum.length;
    
}
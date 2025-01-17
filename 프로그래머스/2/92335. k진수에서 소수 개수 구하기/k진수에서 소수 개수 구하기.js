function solution(n, k) {
    const isPrime = (p) => {
        if(p==1 || !p) return false;
        for(let i=2;i<=Math.sqrt(p);i++){
           if(p % i === 0) return false;
        }
        return true;
    }

    return n.toString(k).split("0").filter((item)=> isPrime(item)).length;
}

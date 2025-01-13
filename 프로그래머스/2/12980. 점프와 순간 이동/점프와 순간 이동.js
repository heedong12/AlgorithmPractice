function solution(n)
{
    var ans = 1;
    
    while(n!==1){
        if(n%2 != 0){
            n--;
            ans++
        }
        n/=2
    }
    
    return ans;
}
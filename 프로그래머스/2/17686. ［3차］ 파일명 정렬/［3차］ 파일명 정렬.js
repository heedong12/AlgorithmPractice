function solution(files) {
    let copyFile = JSON.parse(JSON.stringify(files))
    
    const NUMBER = [0,1,2,3,4,5,6,7,8,9].map(String)
    
    const splitString = (string) =>{
        let [head, number,tail]= ["",0,""]
        for(let i=0;i<string.length;i++){
            if(NUMBER.includes(string[i])){
                let startIdx=i;
               while(NUMBER.includes(string[i]) && i<string.length){
                   i++
               }
               head = string.slice(0,startIdx)
                number=string.slice(startIdx,i)
                tail =string.slice(i)
                break;
            }
        }
        return [head,number,tail];
    }
    
   
    copyFile.sort((a,b) => {
        let [headA, numberA, tailA] = splitString(a)        
        let [headB, numberB, tailB] = splitString(b)

        if(headA.toUpperCase() != headB.toUpperCase()){
            return headA.toUpperCase().localeCompare(headB.toUpperCase())
        }
        
        if(Number(numberA) != Number(numberB)){
            return Number(numberA) > Number(numberB) ? 1 : -1;
        }
        
        return 0;
        
    })

    return copyFile;
}
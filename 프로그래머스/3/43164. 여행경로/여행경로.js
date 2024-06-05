function solution(tickets) {
    var answer = [];
    let visit = new Array(tickets.length).fill(false);
    let sortedTickets = tickets.sort();
    let len = sortedTickets.length;
    
    let r = []

    answer.push("ICN");
    const DFS = (str) => {    
        if(answer.length === len+1) return;
        
        for(let i=0;i<len;i++){
            if(!visit[i] && str == sortedTickets[i][0]){
                visit[i]=true;
                answer.push(sortedTickets[i][1]);
                DFS(sortedTickets[i][1]);
                if(answer.length === len+1) return;
                answer.pop();
                visit[i]=false;
            }
        }
    }
    
    DFS("ICN");
    
    return answer;
}
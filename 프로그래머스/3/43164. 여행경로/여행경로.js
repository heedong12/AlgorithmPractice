function solution(tickets) {
    var answer = [];
    let visit = new Array(tickets.length).fill(false);
    let sortedTickets = tickets.sort();
    let len = sortedTickets.length;
    
    answer.push("ICN");
    const DFS = (str) => {    
      for(let i=0;i<len;i++){
          if(!visit[i] && str == sortedTickets[i][0]){
              answer.push(sortedTickets[i][1]);
              visit[i]=true;
              DFS(sortedTickets[i][1]);
              if(answer.length == len+1) return;
              visit[i]=false;
              answer.pop();
          }
      }
    }
    
    DFS("ICN");
    
    return answer;
}
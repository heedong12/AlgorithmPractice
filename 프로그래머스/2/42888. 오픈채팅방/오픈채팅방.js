function solution(record) {
    var answer = [];
    let nickname = new Map()
    let log = []
    
    record.forEach((item,idx)=>{
       let [chat, id, nick] = item.split(" ")
       if(chat==="Enter" || chat ==="Change")nickname.set(id, nick)
       log.push([chat,id,nick])
    })
    console.log(log)
    
    log.forEach(([chat, id, nick])=>{
        if(chat === "Enter") answer.push(`${nickname.get(id)}님이 들어왔습니다.`)
        if(chat === "Leave") answer.push(`${nickname.get(id)}님이 나갔습니다.`)
    })

    return answer;
}
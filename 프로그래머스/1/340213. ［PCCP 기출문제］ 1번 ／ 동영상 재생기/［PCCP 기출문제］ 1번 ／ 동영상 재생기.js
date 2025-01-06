function solution(video_len, pos, op_start, op_end, commands) {
    // 초로 계산
    const changeTimeToSecond = (time) =>{
        const [minute,second] = time.split(':')
        
        return Number(minute)*60 + Number(second);
    }

    video_len = changeTimeToSecond(video_len)
    pos = changeTimeToSecond(pos)
    op_start = changeTimeToSecond(op_start)
    op_end = changeTimeToSecond(op_end)
    
    commands.forEach(item => {
         // 오프닝 범위
        if(pos<=op_end && pos>=op_start) {
            pos = op_end
        }
        
        if(item === 'prev'){
            pos = pos-10 < 0 ? 0 : pos-10
        } else {
            pos = pos+10 > video_len ? video_len : pos+10
        }
        
    })
    
     // 오프닝 범위
    if(pos<=op_end && pos>=op_start) {
        pos = op_end
    }
    
    let min = Math.floor(pos/60)
    let sec = pos % 60

    min = min.toString().padStart(2,'0')
    sec = sec.toString().padStart(2,'0')
    
    return min+":"+sec;
}
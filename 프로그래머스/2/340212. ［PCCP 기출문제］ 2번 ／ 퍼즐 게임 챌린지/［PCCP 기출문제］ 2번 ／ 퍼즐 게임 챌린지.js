function solution(diffs, times, limit) {
    const gameInfos = diffs.map((diff, idx) => {
        const failTime = idx === 0 ? times[idx] : times[idx - 1] + times[idx];
        return [diff, times[idx], failTime];
    });

    let start = 1;
    // let end = Math.max(...diffs);
    let end = diffs.reduce((prev,cur)=>{
        return prev > cur ? prev : cur
    })
    let answer = end;

    while (start <= end) {
        let mid = Math.floor((start + end) / 2);
        let sumTime = 0;

        gameInfos.forEach(([level, time, failTime]) => {
            let failNum = Math.max(0, level - mid);
            sumTime += time + failTime * failNum;
        });

        if (sumTime <= limit) {
            answer = mid; 
            end = mid - 1; 
        } else {
            start = mid + 1; 
        }
    }

    return answer;
}

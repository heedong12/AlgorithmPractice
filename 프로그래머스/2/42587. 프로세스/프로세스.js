function solution(priorities, location) {
    let answer = 0;
    let queue = priorities.map((priority, index) => ({ priority, index }));

    while (queue.length > 0) {
        const currentProcess = queue.shift();
        const isHighPriority = queue.some(process => process.priority > currentProcess.priority);
        
        if (isHighPriority) {
            queue.push(currentProcess);
        } else {
            answer++;
            if (currentProcess.index === location) {
                return answer;
            }
        }
    }

    return answer;
}


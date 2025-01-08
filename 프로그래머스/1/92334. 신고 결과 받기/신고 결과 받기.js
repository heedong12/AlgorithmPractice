function solution(id_list, report, k) {
    const reportMap = {};
    const answer = {}

    id_list.forEach((item) => {
        reportMap[item] = new Set(); 
        answer[item]=0;
    });
    
    report.forEach((item)=>{
        const [report, reported] = item.split(' ')
        reportMap[reported].add(report)
    })

    for(const map in reportMap){
        if(reportMap[map].size >= k){
            reportMap[map].forEach((name)=>{
                answer[name]++
            })
        }
    }

    return Object.values(answer)
}
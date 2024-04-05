function solution(cacheSize, cities) {
    var answer = 0;
    let cache = [];
    
    for(let i=0;i<cities.length;i++){
        let upperCity = cities[i].toUpperCase();

        // if(i<cacheSize ) {
        //     cache.push(upperCity);
        //     answer+=5;
        //     continue;
        // }
        if(cache.includes(upperCity)){
            cache.splice(cache.indexOf(upperCity), 1);
            cache.push(upperCity);
            answer+=1;
            continue;
        }
        cache.push(upperCity);
        if(cache.length>cacheSize){
        cache.splice(0, 1);
        }
        answer+=5;
    }
    return answer;
}
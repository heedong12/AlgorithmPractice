function solution(people, limit) {
    var answer = 0;
    people.sort((a, b) => a-b); // 오름차순 정렬
    let left = 0;   //가장 가벼운 사람
    let right = people.length - 1;  //가장 무거운 사람

    while (left <= right) { 
        if (people[left] + people[right] <= limit) {
            left++;     
            right--;
        } else {
            right--;
        }
        answer++;
    }

    return answer;
}

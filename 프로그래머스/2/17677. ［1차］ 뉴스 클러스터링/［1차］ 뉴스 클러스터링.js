function solution(str1, str2) {
  const allowChar = /^[a-zA-Z]*$/;

  const makeSet = (str) => {
    const map = new Map();
    const lowerStr = str.toLowerCase();

    for (let i = 1; i < lowerStr.length; i++) {
      const bigram =lowerStr[i-1] + lowerStr[i];
      if (allowChar.test(bigram)) {
        map.set(bigram, (map.get(bigram) || 0) + 1);
      }
    }
    return map;
  };

  const map1 = makeSet(str1);
  const map2 = makeSet(str2);

  let intersectionNum = 0;
  let unionNum = 0;

  for (const [key, count1] of map1) {
    const count2 = map2.get(key) || 0;
    intersectionNum += Math.min(count1, count2);
    unionNum += Math.max(count1, count2);
    map2.delete(key);
  }

  for (const count of map2.values()) {
    unionNum += count;
  }

  if (unionNum === 0) return 65536;
  return Math.floor((intersectionNum / unionNum) * 65536);
}

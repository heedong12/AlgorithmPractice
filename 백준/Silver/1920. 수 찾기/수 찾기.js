const filePath = process.platform === "linux" ? "/dev/stdin" : "ex.txt";

const input = require("fs")
  .readFileSync(filePath)
  .toString()
  .trim()
  .split("\n");

var [N, arr1, M, arr2] = input;
arr1 = arr1.split(" ").map(Number);
arr1.sort((a, b) => {
  return a - b;
});
arr2 = arr2.split(" ").map(Number);

const binarySearch = (target, arr) => {
  var start = 0;
  var end = N - 1;
  var mid;

  while (start <= end) {
    mid = Math.floor((start + end) / 2);

    if (arr[mid] === target) {
      return 1;
    } else {
      if (arr[mid] > target) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }
  }
  return 0;
};

arr2.forEach((item, idx) => {
  console.log(binarySearch(item, arr1));
});

function solution(n, tops) {
  var answer = 0;
  const MOD = 10007;
  let a = [];
  let b = [];

  a[1] = 1;
  b[1] = tops[0] == 1 ? 3 : 2;

  for (let i = 2; i <= n; i++) {
    a[i] = (a[i - 1] + b[i - 1]) % MOD;

    if (tops[i - 1] == 1) {
      b[i] = (2 * a[i - 1] + 3 * b[i - 1]) % MOD;
    }   
    if (tops[i - 1] == 0) {
      b[i] = (a[i - 1] + 2 * b[i - 1]) % MOD;
    }
  }
  answer = (a[n] + b[n]) % MOD;

  return answer;
}

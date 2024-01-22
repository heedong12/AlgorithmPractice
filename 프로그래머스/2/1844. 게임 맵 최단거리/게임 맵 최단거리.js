function solution(maps) {
  const rows = maps.length;
  const cols = maps[0].length;

  //순서대로 상우하좌(시계방향)
  const dx = [0, 1, 0, -1];
  const dy = [-1, 0, 1, 0];

  const queue = [];
  queue.push([0, 0, 1]);

  while (queue.length > 0) {
    const [x, y, distance] = queue.shift();

    //도착지점 도착
    if (x === cols - 1 && y === rows - 1) {
      return distance;
    }

    for (let i = 0; i < 4; i++) {
      const nx = x + dx[i];
      const ny = y + dy[i];

      //좌표의 위치가 범위안에 있고, 벽이 없는 자리 일때(=1)
      if (nx >= 0 && nx < cols && ny >= 0 && ny < rows && maps[ny][nx] == 1) {
        queue.push([nx, ny, distance + 1]);
        maps[ny][nx] = 0;
      }
    }
  }
  //도착할 수 없는 경우
  return -1;
}
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static char arr[][];
    static boolean visit[][];
    static int N, M;
    static int[] dx = {1, 0, -1, 0};    // 오른쪽, 아래, 왼쪽, 위 좌표
    static int[] dy = {0, 1, 0, -1};    // 오른쪽, 아래, 왼쪽, 위 좌표
    static int temp, sumW=0, sumB=0;

    static void dfs(int x, int y) {
        visit[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];     // x좌표 계산
            int ny = y + dy[i];     // y좌표 계산
            if (nx >= 0 && nx < M && ny >= 0 && ny < N && !visit[nx][ny] && arr[x][y] == arr[nx][ny]) {
                temp++;
                dfs(nx, ny);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 가로 크기
        M = Integer.parseInt(st.nextToken()); // 세로 크기
        arr = new char[M][N];
        visit = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = s.charAt(j); // 병사들의 옷 색 저장
            }
        }
        
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j]) {
                    temp = 1;
                    dfs(i, j);
                    if (arr[i][j] == 'W') {
                        sumW += temp * temp;
                    } else if (arr[i][j] == 'B') {
                        sumB += temp * temp;
                    }
                }
            }
        }

        bw.write(sumW + " " + sumB);
        bw.close();
        br.close();
    }
}

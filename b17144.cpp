#include<bits/stdc++.h>
using namespace std;

int R, C, T;
int Map[51][51];
vector<pair<int, int>> purify;


int dx[4] = {1,-1,0,0};
int dy[4] = {0,0,1,-1};

void make_Map(){
    for (int i = 0; i < R; i++)
    {
        for (int j = 0; j < C; j++)
        {
            cin >> Map[i][j];
            if(Map[i][j] == -1){
                purify.push_back(make_pair(i,j));
            }
        }
        
    }
    
    
}

// 미세먼지 확산 함수
void spread() {
    int temp[51][51] = {0};
    int dx[4] = {1, -1, 0, 0};
    int dy[4] = {0, 0, 1, -1};

    for (int r = 0; r < R; r++) {
        for (int c = 0; c < C; c++) {
            if (Map[r][c] > 0) {
                int spreadAmount = Map[r][c] / 5;
                for (int i = 0; i < 4; i++) {
                    int nx = r + dx[i];
                    int ny = c + dy[i];

                    if (nx >= 0 && nx < R && ny >= 0 && ny < C && Map[nx][ny] != -1) {
                        temp[nx][ny] += spreadAmount;
                        Map[r][c] -= spreadAmount;
                    }
                }
            }
        }
    }

    for (int r = 0; r < R; r++) {
        for (int c = 0; c < C; c++) {
            Map[r][c] += temp[r][c];
        }
    }
}

void  circular(){ //다음 위치가 공기 청정기이면 소멸
    int airR = purify[0].first;
    int airC = purify[0].second;

    // 상단
    for (int r = airR - 1; r > 0; r--) {
        Map[r][0] = Map[r - 1][0];
    }
    // 우측
    for (int c = 0; c < C - 1; c++) {
        Map[0][c] = Map[0][c + 1];
    }
    // 하단
    for (int r = 0; r < airR; r++) {
        Map[r][C - 1] = Map[r + 1][C - 1];
    }
    // 좌측
    for (int c = C - 1; c > 1; c--) {
        Map[airR][c] = Map[airR][c - 1];
    }
    Map[airR][1] = 0;

    // 아래쪽 공기청정기 순환
    airR = purify[1].first;
    airC = purify[1].second;

    // 상단
    for (int r = airR + 1; r < R - 1; r++) {
        Map[r][0] = Map[r + 1][0];
    }
    // 우측
    for (int c = 0; c < C - 1; c++) {
        Map[R - 1][c] = Map[R - 1][c + 1];
    }
    // 하단
    for (int r = R - 1; r > airR; r--) {
        Map[r][C - 1] = Map[r - 1][C - 1];
    }
    // 좌측
    for (int c = C - 1; c > 1; c--) {
        Map[airR][c] = Map[airR][c - 1];
    }
    Map[airR][1] = 0;
}

int Sum(){
    int value = 0;
    for (int i = 0; i < R; i++)
    {
        for (int j = 0; j < C; j++)
        {
            if(Map[i][j] == -1) continue;
            value += Map[i][j];
        }
        
    }
    return value;
}
int main(void)
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> R >> C >> T;

    make_Map();
    while(T--){
        spread();
        circular();
    }

    cout << Sum() << '\n';
    
    return 0;
}

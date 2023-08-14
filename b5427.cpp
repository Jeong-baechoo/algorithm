#include<bits/stdc++.h>
using namespace std;

int dx[4] = {1,-1,0,0};
int dy[4] = {0,0,1,-1};

struct Pos {
    int x;
    int y;
    char c; // '불'을 의미하는 '*' 또는 '상근이'를 의미하는 '@'
    int second;
};

vector<vector<char>> Map;

int bfs(int W, int H){
    queue<Pos> fire_q;
    queue<Pos> person_q;
    
    for (int i = 0; i < H; i++) {
        for (int j = 0; j < W; j++) {
            if (Map[i][j] == '*') {
                fire_q.push({i, j, Map[i][j], 0});
            } else if (Map[i][j] == '@') {
                person_q.push({i, j, Map[i][j], 0});
            }
        }
    }
    
    while (!person_q.empty())
    {
        // 불 확산 처리
        int fire_q_size = fire_q.size();
        for (int k = 0; k < fire_q_size; k++) {
            int x = fire_q.front().x;
            int y = fire_q.front().y;
            fire_q.pop();

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < H && ny >= 0 && ny < W && Map[nx][ny] == '.') {
                    Map[nx][ny] = '*';
                    fire_q.push({nx, ny, '*', 0});
                }
            }
        }

        // 상근이의 이동 처리
        int person_q_size = person_q.size();
        for (int k = 0; k < person_q_size; k++) {
            int x = person_q.front().x;
            int y = person_q.front().y;
            int second = person_q.front().second;
            person_q.pop();

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= H || ny < 0 || ny >= W) {
                    return second + 1;
                }

                if (Map[nx][ny] == '.') {
                    Map[nx][ny] = '@';
                    person_q.push({nx, ny, '@', second + 1});
                }
            }
        }
    }
    return -1;
}

int main(int argc, char const *argv[])
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    int T;
    cin >> T; //테스트케이스

    while (T--)
    {
        int W,H;
        cin >> W >> H;

        Map = vector<vector<char>>(H, vector<char>(W));
        for (int i = 0; i < H; i++)
        {
            for (int j = 0; j < W; j++)
            {
                cin >> Map[i][j];
            }
        }
        int Count = bfs(W,H);
        if(Count == -1){
            cout << "IMPOSSIBLE" << endl;
        } else{
            cout << Count << endl;
        }
    }
    
    return 0;
}
